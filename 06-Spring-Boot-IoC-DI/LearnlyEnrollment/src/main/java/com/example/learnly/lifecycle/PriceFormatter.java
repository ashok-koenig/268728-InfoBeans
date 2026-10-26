package com.example.learnly.lifecycle;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PriceFormatter {
    public String format(BigDecimal amount){
        return "INR "+ amount.setScale(2, RoundingMode.HALF_UP);
    }
}
