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
    }
}
