package com.example.shopkart.dto

data class OrderRequest(
    val customer: String,
    val lines: List<LineRequest>
)

data class LineRequest(
    val productId: Long,
    val quantity: Int,
)
