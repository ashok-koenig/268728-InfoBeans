package custom;

import model.Product;

public class InsufficientStockException extends ShopException{
    private final Product product;
    private final int requested;
    private final int available;

    public InsufficientStockException(Product product, int requested, int available) {
        super("Not enough "+ product.name());
        this.product = product;
        this.requested = requested;
        this.available = available;
    }

    public Product getProduct() {
        return product;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}
