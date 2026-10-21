package lambdas;

import model.Product;
import model.SampleData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(SampleData.products());

        // Lambda shapes
        Supplier<String> shop = () -> "ShopKart";
        Function<Double, Double> withTax = price -> price * 1.18;
        Comparator<Product> byPrice = (a, b) -> a.price().compareTo(b.price());
        Comparator<Product> byNameLength = (a, b) -> {
            int diff = a.name().length() - b.name().length();
            return diff !=0 ?diff : a.name().compareTo(b.name());
        };

        System.out.println(shop.get() + " tax on 100: "+ withTax.apply(100.00));
        products.sort(byPrice);
        System.out.println("By price: "+ products.stream().map(Product::name).toList());
        products.sort(byNameLength);
        System.out.println("By name length: " + products.stream().map(Product::name).toList());
    }
}
