package custom;

public class OrderNotFoundException extends ShopException{
    private final String orderId;

    public OrderNotFoundException(String orderId) {
        super("No order with id: "+ orderId);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
