package custom;

import model.*;

public class OrderService {
    private final InventoryService inventory;
    private final PaymentService payment;

    public OrderService(InventoryService inventory, PaymentService payment) {
        this.inventory = inventory;
        this.payment = payment;
    }

    public String place(String orderId, Customer customer, Product product, int qty, PaymentMethod method){
        Money amount = product.price().times(qty);
        inventory.reserve(product, qty);
        try{
            payment.charge(method, amount);
        }catch (PaymentDeclinedException e){
            inventory.release(product, qty);
            throw e;
        }
        return "Order "+ orderId + " placed: " + qty + " x " + product.name() + " for " + customer + " amount: " + amount;
    }

    public Order find(String orderId){
        return SampleData.orders().stream()
                .filter(o-> o.id().equals(orderId))
                .findFirst()
                .orElseThrow( ()-> new OrderNotFoundException(orderId));
    }
}
