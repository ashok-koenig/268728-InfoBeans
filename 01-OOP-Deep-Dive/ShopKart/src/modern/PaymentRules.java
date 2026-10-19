package modern;

public class PaymentRules {
    public static String describe(PaymentMethod payment){
        return switch (payment){
            case Card card -> "Card: "+ card.number();
            case Upi upi -> "UPI ID: "+ upi.id();
            case Cash cash -> "Cash of Delivery";
            case Wallet wallet -> "Wallet Provider: "+ wallet.provider();
        };
    }

    public static Money gatewayFee(PaymentMethod payment, Money amount) {
        return switch (payment) {
            case Card card -> amount.percent(2);
            case Upi upi -> Money.inr("0");
            case Cash cash -> Money.inr("50");
            case Wallet wallet -> amount.percent(1);
        };
    }

}
