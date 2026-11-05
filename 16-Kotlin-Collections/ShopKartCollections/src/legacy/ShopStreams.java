package legacy;

import model.Order;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// The Module 3 report, as it was written with Streams
public class ShopStreams {

    public static Map<String, Double> revenueByRegion(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::region, TreeMap::new, Collectors.summingDouble(Order::totalAmount)));
    }
}
