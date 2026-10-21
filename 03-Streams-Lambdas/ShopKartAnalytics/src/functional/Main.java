package functional;

//class PercentOffer implements DiscountRule{
//    private final double PER = 0.10;
//    @Override
//    public double apply(double price) {
//        return price * PER;
//    }
//}

import model.Category;
import model.Product;
import model.SampleData;

import java.util.function.Function;
import java.util.function.Predicate;

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
    }
}
