package com.example.shopkart.dto

data class OrderRequest(
    val customer: String,
    val lines: List<LineRequest>
)

data class LineRequest(
    val productName: String,
    val quantity: Int,
)
