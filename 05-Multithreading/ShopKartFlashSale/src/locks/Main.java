package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    }
}
