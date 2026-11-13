package com.example.shopkart.entity

import jakarta.persistence.*

@Entity
@Table(name = "order_line")
class OrderLine(
    var productName: String,

    var quantity: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null
}