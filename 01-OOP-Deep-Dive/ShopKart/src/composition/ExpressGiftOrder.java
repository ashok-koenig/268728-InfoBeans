package composition;

// Express AND gift: we must copy the gift logic. Add "insured" and the classes multiply.
public class ExpressGiftOrder extends ExpressOrder {
    public ExpressGiftOrder(double amount) {
        super(amount);
    }

    @Override
    public double total() {
        return super.total() + 99;
    }
}
