package com.example.shopkart.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    var customer: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val placedAt: LocalDateTime = LocalDateTime.now()

    @OneToMany(mappedBy = "order")
    val lines: MutableList<OrderLine> = mutableListOf()

    fun addLine(line: OrderLine) {
        lines.add(line)
        line.order = this
    }
    fun removeLine(line: OrderLine) {
        lines.remove(line)
        line.order = null
    }
}