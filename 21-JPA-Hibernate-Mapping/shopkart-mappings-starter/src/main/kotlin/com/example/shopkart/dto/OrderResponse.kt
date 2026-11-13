package com.example.shopkart.dto

import com.example.shopkart.entity.Order
import com.example.shopkart.entity.OrderLine
import java.time.LocalDateTime

data class OrderResponse(
    val id: Long,
    val customer: String,
    val placedAt: LocalDateTime,
    val lines: List<LineResponse>
)

data class LineResponse(
    val lineId: Long?,
    val productName: String,
    val quantity: Int,
)

fun OrderLine.toResponse() = LineResponse(id, productName, quantity)

fun Order.toResponse() = OrderResponse(id!!, customer, placedAt, lines.map { it.toResponse() })