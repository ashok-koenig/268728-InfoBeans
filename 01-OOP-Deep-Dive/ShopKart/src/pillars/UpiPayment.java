package pillars;

public class UpiPayment implements PaymentMethod {

    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Collect request of Rs. "+ amount + " sent to "+ upiId);
    }
}
