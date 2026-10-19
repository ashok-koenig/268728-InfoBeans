package composition;

public class BasicOrder {
    protected final double amount;

    public BasicOrder(double amount) {
        this.amount = amount;
    }

    public double total() {
        return amount + 50;
    }
}
