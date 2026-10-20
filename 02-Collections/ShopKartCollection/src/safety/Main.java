package safety;

import model.Item;
import model.SampleData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

//        Map<String, Integer> sales = new HashMap<>();
        Map<String, Integer> sales = new ConcurrentHashMap<>();
        Runnable counter = () -> {
            for (int i=0; i<1000; i++){
                sales.merge("Laptop", 1, Integer::sum);
            }
        };
        Thread a = new Thread(counter);
        Thread b = new Thread(counter);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("Laptop sold: "+ sales.get("Laptop"));
    }
}
