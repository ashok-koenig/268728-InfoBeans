package collectors;

import model.Order;
import model.SampleData;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        // toList and joining
        System.out.println("Customers: "+ orders.stream()
                .map(o-> o.customer().name())
                .distinct()
                .collect(Collectors.joining(", "))
        );
        System.out.println("Ids: "+ orders.stream()
                .map(Order::id)
                .collect(Collectors.joining(" | ", "<", ">" ))
        );

        // groupingBy: region wise grouping of orders.
        Map<String, List<Order>> ordersByRegion = orders.stream().collect(Collectors.groupingBy(Order::region));
        System.out.println("Order by region: "+ ordersByRegion);

        Map<String, List<String>> idsByRegion = orders.stream().collect(Collectors.groupingBy(Order::region, TreeMap::new,
                Collectors.mapping(Order::id, Collectors.toList())));
        System.out.println("Order ids by region: "+ idsByRegion);

        Map<String, Long> ordersPerRegion = orders.stream().collect(Collectors.groupingBy(Order::region, TreeMap::new,
                Collectors.counting()));
        System.out.println("Order per region: "+ ordersPerRegion);

        Map<String, Double> revenuePerRegion = orders.stream().collect(Collectors.groupingBy(Order::region, TreeMap::new,
                Collectors.summingDouble(Order::totalAmount)));
        System.out.println("Revenue per region: "+ revenuePerRegion);

        // partitioningBy: Big orders vs Small (10000)
        Map<Boolean, Long> bigOrSmall = orders.stream()
                .collect(Collectors.partitioningBy(o-> o.totalAmount() >=10000, Collectors.counting()));
        System.out.println("Big orders vs small: "+ bigOrSmall);
    }
}
