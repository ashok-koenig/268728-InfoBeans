package composition;

public class GiftOrder extends BasicOrder {
    public GiftOrder(double amount) {
        super(amount);
    }

    @Override
    public double total() {
        return super.total() + 99;
    }
}
