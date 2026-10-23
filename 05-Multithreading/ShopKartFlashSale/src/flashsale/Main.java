package flashsale;

import model.SampleData;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FlashSale sale = new FlashSale(SampleData.PHONE, 100);

        ExecutorService shoppers = Executors.newFixedThreadPool(8);
        List<Future<Boolean>> attempts = new ArrayList<>();
        for(int i=0; i<500; i++){
            attempts.add(shoppers.submit(sale::buy));
        }
        int sold =0;
        int rejected =0;
        for(Future<Boolean> attempt: attempts){
            if(attempt.get()){
                sold++;
            }else {
                rejected++;
            }
        }

        System.out.println("Sold: "+ sold);
        System.out.println("Rejected: "+ rejected);
        System.out.println("Stock left: "+ sale.stockLeft());
        System.out.println("Revenue: "+ sale.revenue());
        shoppers.shutdown();
        shoppers.awaitTermination(10, TimeUnit.SECONDS);
    }
}
