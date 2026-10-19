package composition;

public class StandardShipping implements ShippingPolicy{
    @Override
    public double cost(double amount) {
        return  amount >= 500? 0: 50;
    }
}
