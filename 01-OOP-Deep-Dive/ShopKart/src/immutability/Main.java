package immutability;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> cart = new ArrayList<>();
        cart.add(new Item("Laptop", 65000));

        // Before: the order shares the caller's list
        LeakyOrder leaky = new LeakyOrder(cart);
        System.out.println("Leaky total at checkout: " + leaky.total());
        cart.add(new Item("Free Gift Card", -5000));
        System.out.println("Leaky total after caller edits cart: " + leaky.total());

        // After: the order keeps its own unmodifiable copy
        List<Item> cart2 = new ArrayList<>();
        cart2.add(new Item("Laptop", 65000));
        Order safe = new Order(cart2);
        cart2.add(new Item("Free Gift Card", -5000));
        System.out.println("Safe total after caller edits cart: " + safe.total());

    }
}
