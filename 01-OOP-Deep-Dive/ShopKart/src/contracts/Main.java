package contracts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Product p = new Product("x", 1);
        Laptop laptop = new Laptop("ThinkPad", 65000);
        EBook book = new EBook("Effective Java", 799);

        // Abstract class: shared state + shared code + one abstract hook
        List<Product> products = List.of(laptop, book);
        for (Product p : products) {
            System.out.println(p.label());
        }

        // Interfaces: abilities. Laptop can ship AND be taxed; EBook can only be taxed
        System.out.println("Shipping: Rs." + laptop.shippingCost());
        System.out.println("Laptop tax: Rs." + laptop.taxOn(laptop.getPrice()));
        System.out.println("EBook tax: Rs." + book.taxOn(book.getPrice()));

        // default + static + private methods on an interface
        Notifier notifier = Notifier.of("Asha");
        System.out.println(notifier.confirmation("ORD-1001"));
    }
}
