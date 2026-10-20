package iteration;

import model.Money;
import model.Product;
import model.SampleData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                SampleData.CHAIR, SampleData.LAPTOP, SampleData.PEN,
                SampleData.DESK, SampleData.MOUSE, SampleData.NOTEBOOK
        ));
        // Iterator
        Iterator<Product> it = products.iterator();
        while (it.hasNext()){
            System.out.println("Product "+ it.next().id());
        }

        // ListIterator
        List<Money> prices = new ArrayList<>(List.of(
                SampleData.NOTEBOOK.price(), SampleData.PEN.price(), SampleData.DESK.price()));
        System.out.println("Actual prices: "+ prices);
        ListIterator<Money> li = prices.listIterator();
        while (li.hasNext()){
            Money price = li.next();
            li.set(price.minus(price.percent(10)));
        }
        System.out.println("Sale prices: "+ prices);
        while ((li.hasPrevious())){
            System.out.println("Back: "+ li.previous());
        }

        List<Product> shelf = new ArrayList<>(products);
        try{
            for(Product p: shelf){
                if(SampleData.stock().get(p.name()) == 0){
                    shelf.remove(p);
                }
            }
        }catch (ConcurrentModificationException e){
            System.out.println("Bug: "+ e.getClass().getSimpleName());
        }

        // Fix 1 : Iterator.remove
        List<Product> fix1 = new ArrayList<>(products);
        System.out.println("Count: "+ fix1.size());
        Iterator<Product> fixIt = fix1.iterator();
        while (fixIt.hasNext()){
            if(SampleData.stock().get(fixIt.next().name()) ==0) {
                fixIt.remove();
            }
        }
        System.out.println("Fix 1 left: "+ fix1.size());
        System.out.println("Fix 1 left: "+ fix1);

        // Fix 2: removeIf
        List<Product> fix2 = new ArrayList<>(products);
        fix2.removeIf(p -> SampleData.stock().get(p.name()) ==0);
        System.out.println("Fix 2 left: "+ fix1.size());
    }
}
