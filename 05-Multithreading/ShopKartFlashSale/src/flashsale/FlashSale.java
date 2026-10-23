package flashsale;

import model.Product;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class FlashSale {
    private final Product product;
    private final AtomicInteger stock;
    private final LongAdder revenueInRupees = new LongAdder();
    public FlashSale(Product product, int stock ){
        this.product = product;
        this.stock = new AtomicInteger(stock);
    }
    public boolean buy(){
        while (true){
            int current = stock.get();
            if(current ==0){
                return false;
            }
            if(stock.compareAndSet(current, current-1)){
                revenueInRupees.add(product.price().amount().longValue());
                return true;
            }
        }
    }
    public int stockLeft() {
        return stock.get();
    }
    public long revenue(){
        return revenueInRupees.sum();
    }
    public Product product(){
        return product;
    }
}
