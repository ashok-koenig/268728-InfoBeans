package optionals;

import model.Order;
import model.SampleData;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        Order withCoupon = orders.get(0);
        Order withoutCoupon = orders.get(1);
        System.out.println(withCoupon.id() + "coupon: "+ withCoupon.coupon().orElse("none"));
        System.out.println(withoutCoupon.id() + "coupon: "+ withoutCoupon.coupon().orElse("none"));

        // Optional with Streams

        for(Order order: orders){
            int percent = order.coupon().flatMap(SampleData::discountPercent)
                    .filter(p -> p >=10)
                    .orElse(0);
            System.out.println(order.id() + " discount: "+ percent + "%");
        }

        System.out.println(withoutCoupon.id() + "coupon: "+ withoutCoupon.coupon().orElseGet(()-> defaultCoupon()));

        SampleData.discountPercent("STUDENT5").ifPresentOrElse(
                p-> System.out.println("STUDENT5 gives "+ p + "%"),
                ()-> System.out.println("STUDENT5 not found")
        );
        SampleData.discountPercent("FAKE").ifPresentOrElse(
                p-> System.out.println("FAKE gives "+ p + "%"),
                ()-> System.out.println("FAKE not found")
        );
    }

    private static String defaultCoupon(){
        return "NONE";
    }
}
