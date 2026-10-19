package immutability;

import java.util.List;

public class LeakyOrder {
    private final List<Item> items;

    public LeakyOrder(List<Item> items) {
        this.items = items;
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
