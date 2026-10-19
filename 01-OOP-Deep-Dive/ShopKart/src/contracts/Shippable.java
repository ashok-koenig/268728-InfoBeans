package contracts;

public interface Shippable {
    double weightKg();
    default double shippingCost() {
        return weightKg() * 40;
    }
}
