package pillars;

public class CardPayment implements PaymentMethod{
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Charged Rs. "+ amount + " to card ending: "+ cardNumber.substring(cardNumber.length() - 4));
    }
}
