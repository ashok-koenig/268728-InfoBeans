package com.example.shopkart.repository

import com.example.shopkart.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>