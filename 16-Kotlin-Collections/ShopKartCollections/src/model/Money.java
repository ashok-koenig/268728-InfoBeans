package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

// The Money record from Module 1, with a few helpers added as ShopKart grows
public record Money(BigDecimal amount, String currency) implements Comparable<Money> {

    public Money {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException("amount must be zero or more");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("currency required");
        }
        amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public static Money inr(String amount) {
        return new Money(new BigDecimal(amount), "INR");
    }

    public static Money zero() {
        return inr("0");
    }

    public Money plus(Money other) {
        return new Money(amount.add(other.amount), currency);
    }

    public Money minus(Money other) {
        return new Money(amount.subtract(other.amount), currency);
    }

    public Money times(int qty) {
        return new Money(amount.multiply(BigDecimal.valueOf(qty)), currency);
    }

    public Money percent(int pct) {
        return new Money(amount.multiply(BigDecimal.valueOf(pct)).divide(BigDecimal.valueOf(100)), currency);
    }

    public double asDouble() {
        return amount.doubleValue();
    }

    @Override
    public int compareTo(Money other) {
        return amount.compareTo(other.amount);
    }

    @Override
    public String toString() {
        return currency + " " + amount;
    }
}
