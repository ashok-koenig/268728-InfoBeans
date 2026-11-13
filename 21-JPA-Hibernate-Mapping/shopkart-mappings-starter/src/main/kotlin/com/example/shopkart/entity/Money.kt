package com.example.shopkart.entity

import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class Money(
    val amount: BigDecimal = BigDecimal.ZERO,
    val currency: String = "INR"
)
