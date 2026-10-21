package functional;

//class PercentOffer implements DiscountRule{
//    private final double PER = 0.10;
//    @Override
//    public double apply(double price) {
//        return price * PER;
//    }
//}

import model.*;

import java.io.PrintStream;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
//            DiscountRule terPercentOff = new PercentOffer();
        DiscountRule terPercentOff = price -> price * 0.10;
        DiscountRule flat500Off = price -> price - 500;
        System.out.println("10% off 1000: " + terPercentOff.apply(1000));
        System.out.println("Rs.500 off 1000: " + flat500Off.apply(1000));

        Product laptop = SampleData.LAPTOP;
        Product chair = SampleData.CHAIR;

        // Predicate
        Predicate<Product> inBudget = p -> p.price().asDouble() <= 5000;
        Predicate<Product> furniture = p -> p.category() == Category.FURNITURE;
        System.out.println("Chair in budget and furniture: "+ inBudget.and(furniture).test(chair));
        System.out.println("Laptop over budget: " + inBudget.negate().test(laptop));

        // Function
        Function<Product, String> label = product -> product.name() + " (" + product.price() + ")";
        System.out.println(label.apply(laptop));
        System.out.println("Label Length: "+ label.andThen(String::length).apply(laptop));

        // Consumer
        Consumer<Product> priter = p -> System.out.println("Product: "+ p.name());
        SampleData.products().forEach(priter);

        // Supplier
        Customer guest = new Customer(0, "Guest", new Address("Indore", "432101"));
        Supplier<Order> emptryOrder = () -> new Order("0-0", guest, "North", List.of(), null);
        System.out.println("Default order: "+ emptryOrder.get());

        // BiFunction
        BiFunction<Product, Integer, Money> lineTotal = (p, qty) -> p.price().times(qty);
        System.out.println("3 chairs price: "+ lineTotal.apply(chair, 3));
    }
}
