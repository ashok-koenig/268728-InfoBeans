package com.example.shopkart.repository

import com.example.shopkart.entity.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal

interface ProductRepository : JpaRepository<Product, Long>{
    fun findByCategoryAndPriceAmountLessThanEqual(
        category: String,
        maxPrice: BigDecimal,
        pageable: Pageable,
    ): List<Product>
}