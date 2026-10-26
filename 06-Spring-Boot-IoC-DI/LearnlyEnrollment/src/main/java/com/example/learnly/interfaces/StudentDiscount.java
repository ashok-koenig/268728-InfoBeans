package com.example.learnly.interfaces;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StudentDiscount implements DiscountPolicy{
    @Override
    public String name() {
        return "Student (20% off)";
    }

    @Override
    public BigDecimal apply(BigDecimal price) {
        return price.multiply(new BigDecimal("0.80"));
    }
}
