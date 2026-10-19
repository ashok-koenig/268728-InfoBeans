package immutability;

import java.util.List;

public class Order {
    private final List<Item> items;

    public Order(List<Item> items) {
        this.items = List.copyOf(items);
    }

    public List<Item> getItems() {
        return items;
    }

    public double total(){
        double sum =0;
        for (Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }
}
