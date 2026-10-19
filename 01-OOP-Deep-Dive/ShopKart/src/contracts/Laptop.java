package contracts;

public class Laptop extends Product implements Shippable, Taxable{
    protected Laptop(String name, double price) {
        super(name, price);
    }

    @Override
    public String category() {
        return "Electronics";
    }

    @Override
    public double weightKg() {
        return 1.5;
    }

    @Override
    public double taxRate() {
        return 0.18;
    }
}
