package operations;

import model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

        // FlapMap
        System.out.println("Items per order: "+ orders.stream().map(o->o.items().size()).toList());
        List<Item> allItems = orders.stream().flatMap( o -> o.items().stream()).toList();
        System.out.println("All Items: "+ allItems.stream().map(i -> i.product().name()).toList());

        // Reduce
        double revenue = allItems.stream().map(i-> i.subtotal().asDouble()).reduce(0.00001, Double::sum);
        System.out.println("Revenue: "+ revenue);
        Optional<Double> biggestLine = allItems.stream().map(i -> i.subtotal().asDouble()).reduce(Double::max);
        System.out.println("Biggest line: " + biggestLine.orElse(0.0));

        Money revenueMoney = allItems.stream().map(Item::subtotal).reduce(Money.zero(), Money::plus);
        System.out.println("Revenue as Money: "+ revenueMoney);

        // sorted, distinct, limit: the three priciest different products over orders.

        List<String> top3 = allItems.stream()
                .map(Item::product)
                .distinct()
                .sorted(Comparator.comparing(Product::price).reversed())
                .limit(3)
                .map(Product::name)
                .toList();
        System.out.println("Top 3 products: "+ top3);

        long units = allItems.stream().filter(i -> i.qty() >1).mapToInt(Item::qty).sum();
        System.out.println("Total units orders: "+ units);
    }
}
