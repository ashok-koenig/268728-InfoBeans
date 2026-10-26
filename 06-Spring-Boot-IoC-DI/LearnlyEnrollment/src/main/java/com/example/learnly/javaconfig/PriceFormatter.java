package com.example.learnly.javaconfig;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceFormatter {
    private final String currency;

    public PriceFormatter(String currency) {
        this.currency = currency;
    }

    public String format(BigDecimal amount){
        return currency + " "+ amount.setScale(2, RoundingMode.HALF_UP);
    }
}
