package composition;

import javax.lang.model.element.NestingKind;

public class Order {
    private final String id;
    private final double amount;
    private final ShippingPolicy shipping;
    private final GiftOption gift;

    public Order(String id, double amount, ShippingPolicy shipping, GiftOption gift) {
        this.id = id;
        this.amount = amount;
        this.shipping = shipping;
        this.gift = gift;
    }

    public String getId() {
        return id;
    }

    public double total(){
        return amount + shipping.cost(amount) + gift.fee();
    }
}
