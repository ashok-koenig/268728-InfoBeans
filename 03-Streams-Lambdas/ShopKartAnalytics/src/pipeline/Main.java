package pipeline;

import model.Order;
import model.Product;
import model.SampleData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        // Loop
        double loopTotal = 0;
        for (Order order: orders){
            if(order.totalAmount() >=10000){
                loopTotal += order.totalAmount();
            }
        }
        double steamTotal = orders.stream()
                .filter(o-> o.totalAmount() >= 10000)
                .mapToDouble(Order::totalAmount)
                .sum();

        System.out.println("Loop: "+ loopTotal);
        System.out.println("Stream: " + steamTotal);

        // Laziness
        Stream<Product> plan = SampleData.products().stream()
                .peek(p -> System.out.println("checking: "+ p.name()))
                .filter(p-> p.price().asDouble() > 1000);
        System.out.println("Plan built");
        Optional<Product> first = plan.findFirst();
        System.out.println("First expensive product: "+ first.orElseThrow().name());
    }
}
