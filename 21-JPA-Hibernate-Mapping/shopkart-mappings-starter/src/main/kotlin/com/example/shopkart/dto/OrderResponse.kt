package com.example.shopkart.dto

import com.example.shopkart.entity.Order
import com.example.shopkart.entity.OrderLine
import org.hibernate.validator.constraints.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderResponse(
    val id: Long,
    val customer: String,
    val placedAt: LocalDateTime,
    val lines: List<LineResponse>
)

data class LineResponse(
    val productId: Long,
    val sku: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val currency : String,
)

fun OrderLine.toResponse() =
    LineResponse(id.productId, product.sku, quantity, unitPrice.amount, unitPrice.currency)

fun Order.toResponse() =
    OrderResponse(id!!, customer, placedAt, lines.map { it.toResponse() })