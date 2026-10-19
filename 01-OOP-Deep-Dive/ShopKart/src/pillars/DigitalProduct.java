package pillars;

public class DigitalProduct extends Product{


    public DigitalProduct(String name, double price) {
        super(name, price, Integer.MAX_VALUE);
    }

    @Override
    public String deliveryInfo() {
        return getName() + ": download link sent by email";
    }

    @Override
    public double discount() {
        return getPrice() * 0.10;
    }
}
