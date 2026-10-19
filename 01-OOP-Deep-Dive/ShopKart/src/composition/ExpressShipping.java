package composition;

public class ExpressShipping implements ShippingPolicy{
    @Override
    public double cost(double amount) {
        return 150;
    }
}
