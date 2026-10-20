package sorting;

import model.Product;
import model.SampleData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                SampleData.CHAIR, SampleData.LAPTOP, SampleData.PEN,
                SampleData.DESK, SampleData.MOUSE, SampleData.NOTEBOOK
                ));
        print("Products", products);

        Collections.sort(products);
        print("Natural order (id)", products);

        // Comparator: price based sorting
        products.sort(Comparator.comparing(Product::price));
        print("Cheapest first", products);

        // Chain: category, then price, then name

        Comparator<Product> shelfOrder = Comparator.comparing(Product::category).reversed()
                .thenComparing(Comparator.comparing(Product::price).reversed())
                .thenComparing(Product::name);
        products.sort(shelfOrder);
        print("Shelf order", products);

        // TreeSet with Comparator
        TreeSet<Product> byPrice = new TreeSet<>(Comparator.comparing(Product::price));
        byPrice.addAll(products);
        System.out.println("Cheapest: "+ byPrice.first().name());
        System.out.println("Priciest: "+ byPrice.last().name());
    }

    private static void print(String label, List<Product> products){
        System.out.println(label + ": "+ products.stream().map(Product::id).toList());
    }
}
