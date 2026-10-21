package collectors;

import model.Order;
import model.SampleData;

import java.util.List;
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
    }
}
