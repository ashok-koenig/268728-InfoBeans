package pillars;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Class and object
        Product phone = new Product("Phone", 49999, 10);
        System.out.println(phone.getName() + " in stock: " + phone.getStock());

//        phone.stock = -5;
//        System.out.println("Stock is now "+ phone.stock);

        // 2. Encapsulation: stock changes only through reduceStock()
        phone.reduceStock(3);
        System.out.println("After sale, stock: " + phone.getStock());
        try {
            phone.reduceStock(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        // Inheritance & Polymorphism
        List<Product> catalog = List.of(
                new PhysicalProduct("Laptop", 65000, 5, 1.5),
                new DigitalProduct("Java E-Book", 500),
                new Product("Gift Card", 1000, 100)
        );
        for (Product p: catalog){
            System.out.println(p.deliveryInfo() + " : discount Rs. "+ p.discount());
        }
    }
}
