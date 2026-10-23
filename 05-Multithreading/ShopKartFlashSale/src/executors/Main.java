package executors;

import model.Order;
import model.SampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Callable<Double>> orders = new ArrayList<>();
        for (Order order : SampleData.orders()) {
            orders.add(order::totalAmount);
        }

        Future<Double> single = pool.submit(orders.get(4));
        System.out.println("Single Order total: "+ single.get());
        double sum =0;
        for (Future<Double> future: pool.invokeAll(orders)){
            sum += future.get();
        }
        System.out.println("All orders total: "+ sum);
        // Shutdown
        pool.shutdown();
        System.out.println("Terminated "+ pool.awaitTermination(10, TimeUnit.SECONDS));

        // close does shutdown + wait for us
        ExecutorService scoped = Executors.newFixedThreadPool(2);
        try(scoped){
            scoped.submit(() -> System.out.println("task done inside try-with-resources"));
        }
        System.out.println("Closed after try: " + scoped.isTerminated());
    }
}
