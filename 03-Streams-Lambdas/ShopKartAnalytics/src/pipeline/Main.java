package pipeline;

import model.Order;
import model.SampleData;

import java.util.List;

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
    }
}
