package safety;

import model.Item;
import model.SampleData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> cart = new ArrayList<>(
                List.of(
                        new Item(SampleData.LAPTOP, 1),
                        new Item(SampleData.MOUSE, 2)
                ));

        // Unmodifiable View: Callers cannot change it, but it follows the owner's changes
        List<Item> view = Collections.unmodifiableList(cart);

        // Immutable Snapshot: the receipt, which must never change after checkout
        List<Item> receipt = List.copyOf(cart);

//        receipt.add(new Item(SampleData.CHAIR, 1)); // not possible
//        view.add(new Item(SampleData.CHAIR, 1)); // not possible
        cart.add(new Item(SampleData.DESK, 1));
        System.out.println("Cart count: "+ cart.size());
        System.out.println("View count: "+ view.size());
        System.out.println("Receipt count: "+ receipt.size());
    }
}
