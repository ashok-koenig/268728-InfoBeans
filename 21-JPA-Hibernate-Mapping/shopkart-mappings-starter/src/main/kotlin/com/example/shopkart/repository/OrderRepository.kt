package com.example.shopkart.repository

import com.example.shopkart.entity.Order
import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository: JpaRepository<Order, Long>{

    @EntityGraph(attributePaths = ["lines", "lines.product"])
    override fun findAll(): List<Order>

    @Query("select distinct o from Order o join fetch o.lines l join fetch l.product")
    fun findAllWithLines(): List<Order>
}