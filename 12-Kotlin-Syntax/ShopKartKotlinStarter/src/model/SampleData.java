package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// The same ShopKart day in every module: same products, customers, orders and stock
public class SampleData {
    public static final Product LAPTOP = new Product(1, "Laptop", Category.ELECTRONICS, Money.inr("65000"));
    public static final Product MOUSE = new Product(2, "Mouse", Category.ELECTRONICS, Money.inr("799"));
    public static final Product DESK = new Product(3, "Desk", Category.FURNITURE, Money.inr("8500"));
    public static final Product CHAIR = new Product(4, "Chair", Category.FURNITURE, Money.inr("4200"));
    public static final Product NOTEBOOK = new Product(5, "Notebook", Category.STATIONERY, Money.inr("60"));
    public static final Product PEN = new Product(6, "Pen", Category.STATIONERY, Money.inr("20"));
    public static final Product PHONE = new Product(7, "Phone", Category.ELECTRONICS, Money.inr("49999"));

    public static final Customer ASHA = new Customer(101, "Asha", new Address("Pune", "411001"));
    public static final Customer BOB = new Customer(102, "Bob", new Address("Mumbai", "400001"));
    public static final Customer CHITRA = new Customer(103, "Chitra", new Address("Pune", "411002"));
    public static final Customer DEV = new Customer(104, "Dev", new Address("Delhi", "110001"));
    public static final Customer FARID = new Customer(105, "Farid", new Address("Delhi", "110002"));

    private static final Map<String, Integer> COUPONS = Map.of("WELCOME10", 10, "STUDENT5", 5);

    public static List<Product> products() {
        return List.of(LAPTOP, MOUSE, DESK, CHAIR, NOTEBOOK, PEN);
    }

    public static List<Customer> customers() {
        return List.of(ASHA, BOB, CHITRA, DEV, FARID);
    }

    public static List<Order> orders() {
        return List.of(
                new Order("O1", ASHA, "North",
                        List.of(new Item(LAPTOP, 1), new Item(MOUSE, 2)), "WELCOME10"),
                new Order("O2", BOB, "South",
                        List.of(new Item(DESK, 1), new Item(CHAIR, 2)), null),
                new Order("O3", CHITRA, "North",
                        List.of(new Item(NOTEBOOK, 10), new Item(PEN, 20)), "STUDENT5"),
                new Order("O4", DEV, "East",
                        List.of(new Item(CHAIR, 1), new Item(MOUSE, 1)), null),
                new Order("O5", ASHA, "South",
                        List.of(new Item(NOTEBOOK, 5)), "WELCOME10"),
                new Order("O6", FARID, "East",
                        List.of(new Item(LAPTOP, 1), new Item(DESK, 1)), null));
    }

    // A fresh, changeable copy every time: stock by product name
    public static Map<String, Integer> stock() {
        return new HashMap<>(Map.of(
                "Laptop", 3, "Mouse", 0, "Desk", 2, "Chair", 0,
                "Notebook", 100, "Pen", 250, "Phone", 100));
    }

    public static Optional<Integer> discountPercent(String code) {
        return Optional.ofNullable(COUPONS.get(code));
    }
}
