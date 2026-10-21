package operations;

import model.Order;
import model.Product;
import model.SampleData;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();
        List<Product> products = SampleData.products();

        // Filter
        System.out.println("Over Rs.1000: " +
                products.stream().filter(p -> p.price().asDouble() > 1000)
                        .map(Product::name)
                        .toList()
        );
        System.out.println("Name Lengths: "+ products.stream().map(Product::name).map(String::length).toList());
    }
}
