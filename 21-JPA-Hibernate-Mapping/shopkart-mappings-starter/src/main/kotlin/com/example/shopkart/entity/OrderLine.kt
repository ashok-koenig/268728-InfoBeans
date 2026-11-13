package com.example.shopkart.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "order_line")
class OrderLine(
    @EmbeddedId
    val id: OrderLineId,

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    var quantity: Int,

    var unitPrice: BigDecimal,
)