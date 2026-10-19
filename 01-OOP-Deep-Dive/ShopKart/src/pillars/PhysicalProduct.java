package pillars;

public class PhysicalProduct extends Product{
    private final double weightKg;

    public PhysicalProduct(String name, double price, int stock, double weightKg) {
        super(name, price, stock);
        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public String deliveryInfo() {
        return getName()+ ": courier in 3 days ";
    }

    @Override
    public double discount() {
        return getPrice() * 0.05;
    }
}
