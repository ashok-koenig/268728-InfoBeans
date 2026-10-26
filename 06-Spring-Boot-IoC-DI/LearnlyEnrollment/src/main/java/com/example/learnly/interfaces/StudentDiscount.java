package com.example.learnly.interfaces;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Primary
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
