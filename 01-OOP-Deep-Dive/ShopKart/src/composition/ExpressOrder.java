package composition;

public class ExpressOrder extends BasicOrder {
    public ExpressOrder(double amount) {
        super(amount);
    }

    @Override
    public double total() {
        return amount + 150;
    }
}
