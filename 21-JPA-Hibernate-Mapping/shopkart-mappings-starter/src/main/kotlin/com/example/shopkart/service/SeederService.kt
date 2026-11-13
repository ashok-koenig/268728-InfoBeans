package com.example.shopkart.service

import jakarta.transaction.Transactional
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class SeederService(
    private val jdbc: JdbcTemplate,
) {

    private val categories = listOf(
        "Books", "Electronics", "Fashion", "Home", "Toys", "Sports", "Beauty", "Grocery", "Garden", "Music"
    )

    @Transactional
    fun seedProducts(count: Int): Int {
        jdbc.batchUpdate(
            "insert into product (sku, name, category, price_amount, price_currency, stock) values (?, ?, ?, ?, 'INR', 100)",
            (0 until count).map { i ->
                arrayOf<Any>("SKU-%06d".format(i), "Product $i", categories[i % categories.size], 1 + (i * 37) % 1000)
            },
        )
        return count
    }
}