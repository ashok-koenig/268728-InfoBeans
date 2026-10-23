package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread name: "+ Thread.currentThread().getName());
        // Runnable
        Runnable job = () -> System.out.println("Hi from "+ Thread.currentThread().getName());

        Thread cook = new Thread(job, "cook-1");
        System.out.println("State before start: "+ cook.getState());
        cook.run();
        cook.start();
        cook.join();
        System.out.println("State after join: "+ cook.getState());

        // Two thread at the same time.
        List<String> log = Collections.synchronizedList(new ArrayList<>());
        Thread a = new Thread(()-> log.add("served by cook-A"), "cook-A");
        Thread b = new Thread(()-> log.add("served by cook-B"), "cook-B");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("Log: "+ log);
    }
}
