package custom;

import model.Money;

public class PaymentDeclinedException extends ShopException{
    private final Money amount;

    public PaymentDeclinedException(String reason, Money amount) {
        super("Payment declined: "+ reason);
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }
}
