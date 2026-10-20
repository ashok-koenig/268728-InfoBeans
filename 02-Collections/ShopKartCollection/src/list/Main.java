package list;

import model.Category;
import model.Money;
import model.Product;
import model.SampleData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List: ordered, duplicats allowed, access by index, Declared by interface.
        List<Product> catalogue = new ArrayList<>();
        catalogue.add(SampleData.MOUSE);
        catalogue.add(SampleData.LAPTOP);
        catalogue.add(SampleData.DESK);
        catalogue.add(1, new Product(8, "Keyboard", Category.ELECTRONICS, Money.inr("1499") ));
        System.out.println("Count: "+ catalogue.size());
        System.out.println("Index 2: "+ catalogue.get(2));
        System.out.println("Position of Desk: "+ catalogue.indexOf(SampleData.DESK));
        catalogue.remove(0);
        System.out.println("Count after remove the first element: "+ catalogue.size());

        // LinkedList: cheap at both ends, so it works well for "recently viewed"
        List<String> recentlyViewed = new LinkedList<>();
        for (String viewed: List.of("Laptop", "Mouse", "Desk", "Chair")) {
            recentlyViewed.addFirst(viewed);
            if(recentlyViewed.size() >3){
                recentlyViewed.removeLast();
            }
        }
        System.out.println("Recently Viewed: "+ recentlyViewed);
        System.out.println("Most recent: "+ recentlyViewed.getFirst());
    }
}
