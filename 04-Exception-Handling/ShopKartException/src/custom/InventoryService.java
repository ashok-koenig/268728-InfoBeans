package custom;

import model.Product;
import model.SampleData;

import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = SampleData.stock();
    public void reserve(Product product, int qty){
        int available = stock.getOrDefault(product.name(), 0);
        if(qty > available){
            throw new InsufficientStockException(product, qty, available);
        }
        stock.put(product.name(), available - qty);
    }
    public void release(Product product, int qty){
        stock.merge(product.name(), qty, Integer::sum);
    }
    public int available(Product product){
        return stock.getOrDefault(product.name(), 0);
    }
}
