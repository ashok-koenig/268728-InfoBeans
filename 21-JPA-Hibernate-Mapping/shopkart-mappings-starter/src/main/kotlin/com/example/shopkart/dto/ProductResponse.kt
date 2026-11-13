package com.example.shopkart.dto

import com.example.shopkart.entity.Product
import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val sku: String,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val stock: Int
)

fun Product.toResponse() = ProductResponse(id!!, sku, name, category, price, stock)
