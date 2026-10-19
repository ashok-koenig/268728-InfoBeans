package pillars;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty){
        if(qty <=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(qty > stock){
            throw new IllegalArgumentException("Only "+ stock + " left in stock");
        }
        stock -= qty;
    }

    public String deliveryInfo(){
        return name + ": standard delivery";
    }
    public double discount(){
        return 0;
    }
}
