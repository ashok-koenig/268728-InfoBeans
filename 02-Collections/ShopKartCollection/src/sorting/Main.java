package sorting;

import model.Product;
import model.SampleData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    }

    private static void print(String label, List<Product> products){
        System.out.println(label + ": "+ products.stream().map(Product::id).toList());
    }
}
