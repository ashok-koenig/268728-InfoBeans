package modern;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Money(BigDecimal amount, String currency) {

    public Money {
        if(amount == null || amount.signum() < 0){
            throw new IllegalArgumentException("amount must be zero or more");
        }
        if(currency == null || currency.isBlank()){
            throw new IllegalArgumentException("currency required");
        }
        amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public static Money inr(String amount){
        return new Money(new BigDecimal(amount), "INR");
    }

    public Money plus(Money other){
        return new Money(amount.add(other.amount), currency);
    }

    public Money times(int qty){
        return new Money(amount.multiply(BigDecimal.valueOf(qty)), currency);
    }

    public Money percent(int pct){
        return new Money(amount.multiply(BigDecimal.valueOf(pct)).divide(BigDecimal.valueOf(100)), currency);
    }
}
