package com.example.shopkart.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class OrderLineId(
    val orderId: Long = 0,
    val productId: Long = 0,
) : Serializable
