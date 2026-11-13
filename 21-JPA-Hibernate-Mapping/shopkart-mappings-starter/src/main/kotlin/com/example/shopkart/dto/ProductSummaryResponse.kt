package com.example.shopkart.dto

import com.example.shopkart.entity.Product
import java.math.BigDecimal

data class ProductSummaryResponse(
    val id: Long,
    val sku: String,
    val name: String,
    val category: String,
    val price: BigDecimal,
)

fun Product.toSummary() = ProductSummaryResponse(id!!, sku, name, category, price.amount)
