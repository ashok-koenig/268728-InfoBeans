package virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int TASKS = 10000;
    static void ioCall(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static long runWith(ExecutorService executorService, AtomicInteger done){
        long start = System.nanoTime();
        try (executorService){
            for(int i=0; i< TASKS; i++){
                executorService.submit(()-> {
                    ioCall();
                    done.incrementAndGet();
                });
            }
        }
        return (System.nanoTime() -start) / 1000000;
    }

    public static void main(String[] args) {
        AtomicInteger platformDone = new AtomicInteger();
        long platformMs = runWith(Executors.newFixedThreadPool(50), platformDone);

        AtomicInteger virturalDone = new AtomicInteger();
        long virtualMs = runWith(Executors.newVirtualThreadPerTaskExecutor(), virturalDone);

        System.out.println("Platform Pool: "+ platformDone.get() + " time taken: "+ platformMs);
        System.out.println("Virtual Thread: "+ virturalDone.get() + " time taken: "+ virtualMs);
    }
}
