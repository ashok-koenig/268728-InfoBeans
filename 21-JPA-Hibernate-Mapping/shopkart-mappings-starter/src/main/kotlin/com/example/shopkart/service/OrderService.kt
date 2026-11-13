package com.example.shopkart.service

import com.example.shopkart.dto.OrderRequest
import com.example.shopkart.dto.OrderResponse
import com.example.shopkart.dto.toResponse
import com.example.shopkart.entity.Order
import com.example.shopkart.entity.OrderLine
import com.example.shopkart.exception.BusinessException
import com.example.shopkart.exception.ErrorKind
import com.example.shopkart.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun create(request: OrderRequest): OrderResponse {
        val order = Order(request.customer)
        request.lines.forEach { order.addLine(OrderLine(it.productName, it.quantity)) }
        return  orderRepository.save(order).toResponse()
    }

    fun get(id: Long): OrderResponse = orderRepository.findById(id)
        .orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "Order $id not found") }
        .toResponse()
}