package completable;

import model.Order;
import model.SampleData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    static void pause(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    static CompletableFuture<String> getUser(int id){
        return CompletableFuture.supplyAsync(()-> {
            pause(50);
            return SampleData.ASHA.name();
        });
    }

    static CompletableFuture<List<String>> getOrders(String name){
        return CompletableFuture.supplyAsync(()->{
            pause(50);
            return SampleData.orders().stream().filter(o -> o.customer().name().equals(name))
                    .map(Order::id)
                    .toList();
        });
    }
    static CompletableFuture<Integer> getDiscount(int userId){
        return CompletableFuture.supplyAsync(()->{
            pause(50);
            return 10;
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> greating = CompletableFuture.supplyAsync( ()-> {
                    pause(50);
                    return SampleData.ASHA.name();
                }).thenApply(String::toUpperCase)
                .thenApply(name -> "Hello "+ name);
        System.out.println(greating.join());

        String summary = getUser(7)
                .thenCompose(user -> getOrders(user))
                .thenCombine(getDiscount(7), (orders, discount) -> orders+"|"+ discount + "% off" )
                .join();
        System.out.println("Summary: "+ summary);

        // exceptionally
        String coupon = CompletableFuture.supplyAsync(()->{
            if(true){
                throw new IllegalStateException("Coupon server down");
            }
            return "WELCOME10";
        }).thenApply(code -> "Coupon "+ code)
                .exceptionally(ex -> "No coupon: "+ ex.getCause().getMessage())
                .join();

        System.out.println(coupon);
    }
}
