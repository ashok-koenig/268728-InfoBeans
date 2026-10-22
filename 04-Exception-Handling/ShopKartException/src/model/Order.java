package model;

import java.util.List;
import java.util.Optional;

// The Order from Module 1 (id, customer, items), now also with a region and an optional coupon
public record Order(String id, Customer customer, String region, List<Item> items, String couponCode) {

    public Order {
        items = List.copyOf(items);                 // defensive copy, as in Module 1
    }

    public Money total() {
        Money sum = Money.zero();
        for (Item item : items) {
            sum = sum.plus(item.subtotal());
        }
        return sum;
    }

    public double totalAmount() {
        return total().asDouble();
    }

    public Optional<String> coupon() {
        return Optional.ofNullable(couponCode);
    }
}
