package com.example.learnly.shared;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public BigDecimal gst(BigDecimal price){
        return price.multiply(new BigDecimal("0.18")).setScale(2, RoundingMode.HALF_UP);
    }
}
