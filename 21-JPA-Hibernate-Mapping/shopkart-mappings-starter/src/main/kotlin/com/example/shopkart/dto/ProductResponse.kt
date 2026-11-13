package com.example.shopkart.dto

import com.example.shopkart.entity.Product
import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val sku: String,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val currency: String,
    val stock: Int,
    val tags: List<String>,
)

fun Product.toResponse() =
    ProductResponse(id!!, sku, name, category, price.amount, price.currency ,stock, tags.map{it.name}.sorted())
