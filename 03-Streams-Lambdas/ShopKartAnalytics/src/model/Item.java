package model;

public record Item(Product product, int qty) {

    public Item {
        if (qty <= 0) {
            throw new IllegalArgumentException("qty must be positive");
        }
    }

    public Money subtotal() {
        return product.price().times(qty);
    }
}
