package setsmaps;

import model.Order;
import model.SampleData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Set: tags on a product, no duplicates
        Set<String> tags = new HashSet<>();
        System.out.println(tags.add("wireless"));
        System.out.println(tags.add("wireless"));
        tags.add("sale");
        System.out.println("Has wireless tag: "+ tags.contains("wireless"));

        Set<String> inOrder = new LinkedHashSet<>(List.of("electronics", "wireless", "sale"));
        System.out.println("Insertion order: "+ inOrder);
        Set<String> sorted = new TreeSet<>(inOrder);
        System.out.println("Sorted: " + sorted);

        // Map: the day's orders groups by customer
        List<OrderSummary> summaries = new ArrayList<>();
        for (Order order: SampleData.orders()){
            summaries.add(new OrderSummary(order.id(),
                    new Customer(order.customer().id(), order.customer().name()),
                    order.total()));
        }
        Map<Customer, List<OrderSummary>> byCustomer = new HashMap<>();
        for (OrderSummary summary: summaries){
            byCustomer.computeIfAbsent(summary.customer(), c-> new ArrayList<>()).add(summary);
        }

        System.out.println("Customers: "+ byCustomer.size());

        // Stock map: put replaces, merge adds, getOrDefault avoids null

        Map<String, Integer> stock = SampleData.stock();
        System.out.println("Stock: "+ stock);
        stock.put("Keyboard", null);
        stock.merge("Pen", 50, Integer::sum); // restock
        stock.merge("Keyboard", 20, Integer::sum); // new product
        System.out.println("Updated Stock: "+ stock);
        System.out.println("Pen Stock: "+ stock.get("Pen"));
        System.out.println("Cups Stock: "+ stock.getOrDefault("Cups", 0));
    }
}
