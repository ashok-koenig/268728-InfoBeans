package com.example.shopkart.service

import com.example.shopkart.dto.OrderRequest
import com.example.shopkart.dto.OrderResponse
import com.example.shopkart.dto.toResponse
import com.example.shopkart.entity.Order
import com.example.shopkart.entity.OrderLine
import com.example.shopkart.exception.BusinessException
import com.example.shopkart.exception.ErrorKind
import com.example.shopkart.repository.OrderRepository
import jakarta.transaction.Transactional
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

    fun get(id: Long): OrderResponse = find(id)
        .toResponse()

    @Transactional
    fun removeLine(orderId: Long, lineId: Long): OrderResponse {
        val order = find(orderId)
        val line = order.lines.firstOrNull { it.id == lineId } ?:
                throw BusinessException(ErrorKind.NOT_FOUND, "List $lineId not found in order $orderId")
        order.removeLine(line)
        return order.toResponse()
    }

    private fun find(id: Long): Order =  orderRepository.findById(id)
        .orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "Order $id not found") }
}