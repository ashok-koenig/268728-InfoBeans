package com.example.shopkart.dto

import com.example.shopkart.entity.Money
import com.example.shopkart.entity.Product
import java.math.BigDecimal

data class ProductRequest(
    val sku: String,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val currency: String="INR",
    val stock: Int
)

fun ProductRequest.toEntity(): Product =
    Product(sku, name, category, Money(price, currency), stock)