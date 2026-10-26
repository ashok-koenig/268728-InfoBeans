package com.example.learnly.interfaces;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FestivalDiscount implements DiscountPolicy{
    @Override
    public String name() {
        return "Festival (30% off)";
    }

    @Override
    public BigDecimal apply(BigDecimal price) {
        return price.multiply(new BigDecimal("0.70"));
    }
}
