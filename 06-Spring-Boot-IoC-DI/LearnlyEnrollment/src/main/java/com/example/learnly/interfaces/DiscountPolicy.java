package com.example.learnly.interfaces;

import java.math.BigDecimal;

public interface DiscountPolicy {
    String name();
    BigDecimal apply(BigDecimal price);
}
