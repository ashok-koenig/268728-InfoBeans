package com.example.shopkart.repository

import com.example.shopkart.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long>