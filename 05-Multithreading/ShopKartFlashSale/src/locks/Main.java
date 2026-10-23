package locks;

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
        onFourThread(()-> {
            for (int i=0; i<10000; i++) synced.increment();
        });
        System.out.println("synchronized: "+ synced.get());
    }
}
