package callable;

import model.Money;
import model.SampleData;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Callable<Money> priceLookup = () -> {
            Thread.sleep(200);
            return SampleData.LAPTOP.price();
        };

        Future<Money> receipt = pool.submit(priceLookup);
        System.out.println("isDone: "+ receipt.isDone());
        System.out.println("Price: "+ receipt.get());
        System.out.println("isDone: "+ receipt.isDone());

        Future<String> slow = pool.submit(()->{
            Thread.sleep(5000);
            return "too slow";
        });
        slow.cancel(true);
//        System.out.println("Price: "+ slow.get());
        System.out.println("Cancelled: "+ slow.isCancelled());

        pool.shutdown();
        System.out.println("Pool finished: "+ pool.awaitTermination(5, TimeUnit.SECONDS));
    }
}
