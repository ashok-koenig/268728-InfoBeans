package locks;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    static class SynchronizedCounter {
        private long count;
        synchronized void increment(){
            count++;
        }
        synchronized long get(){
            return count;
        }
    }

    static class LockCounter {
        private final ReentrantLock lock = new ReentrantLock();
        private long count;
        void increment(){
            lock.lock();
            try {
                count++;
            }finally {
                lock.unlock();
            }
        }
        long get(){
            return count;
        }
    }

    static class PriceList {
        private final ReadWriteLock rw = new ReentrantReadWriteLock();
        private int price = 65000;
        int read(){
            rw.readLock().lock();
            try{
                return price;
            }finally {
                rw.readLock().unlock();
            }
        }
        void write(int newPrice){
            rw.writeLock().lock();
            try{
                price = newPrice;
            }finally {
                rw.writeLock().unlock();
            }
        }
    }

    static void onFourThread(Runnable job) throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i=0;i<threads.length; i++){
            threads[i] = new Thread(job);
            threads[i].start();
        }
        for(Thread thread: threads){
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter synced = new SynchronizedCounter();
        long start = System.nanoTime();
        onFourThread(()-> {
            for (int i=0; i<10000; i++) synced.increment();
        });
        System.out.println("synchronized: "+ synced.get());
        System.out.println("synchronized Time: "+ (System.nanoTime() - start)/1000000);

        LockCounter locked = new LockCounter();
        start = System.nanoTime();
        onFourThread(()-> {
            for (int i=0; i<10000; i++) locked.increment();
        });
        System.out.println("locked: "+ locked.get());
        System.out.println("locked Time: "+ (System.nanoTime() - start)/1000000);

        AtomicLong atomic = new AtomicLong();
        start = System.nanoTime();
        onFourThread(()-> {
            for (int i=0; i<10000; i++) atomic.incrementAndGet();
        });
        System.out.println("AtomicLong: "+ atomic.get());
        System.out.println("AtomicLong Time: "+ (System.nanoTime() - start)/1000000);

        LongAdder adder = new LongAdder();
        start = System.nanoTime();
        onFourThread(()-> {
            for (int i=0; i<10000; i++) adder.increment();
        });
        System.out.println("LongAdder: "+ adder.sum());
        System.out.println("LongAdder Time: "+ (System.nanoTime() - start)/1000000);

        PriceList prices = new PriceList();
        AtomicLong reads = new AtomicLong();
        onFourThread(()-> {
            for (int i=0;i<10000; i++){
                prices.read();
                reads.incrementAndGet();
            }
        });
        prices.write(59999);
        System.out.println("Reads completed: "+ reads.get());
        System.out.println("Price now: "+ prices.read());
    }
}
