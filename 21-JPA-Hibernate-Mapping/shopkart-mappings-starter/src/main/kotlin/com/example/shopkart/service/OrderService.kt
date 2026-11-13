package com.example.shopkart.service

import com.example.shopkart.dto.LineRequest
import com.example.shopkart.dto.OrderRequest
import com.example.shopkart.dto.OrderResponse
import com.example.shopkart.dto.toResponse
import com.example.shopkart.entity.Order
import com.example.shopkart.entity.OrderLine
import com.example.shopkart.entity.OrderLineId
import com.example.shopkart.entity.Product
import com.example.shopkart.exception.BusinessException
import com.example.shopkart.exception.ErrorKind
import com.example.shopkart.repository.OrderRepository
import com.example.shopkart.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orders: OrderRepository,
    private val products: ProductRepository,
) {
    @Transactional
    fun create(request: OrderRequest): OrderResponse {
        val order = orders.save(Order(request.customer))
        request.lines.forEach { addLine(order, it) }
        return order.toResponse()
    }


    fun get(id: Long): OrderResponse = find(id).toResponse()

    @Transactional
    fun addLine(orderId: Long, request: LineRequest): OrderResponse {
        val order = find(orderId)
        addLine(order, request)
        return order.toResponse()
    }

    @Transactional
    fun removeLine(orderId: Long, productId: Long): OrderResponse {
        val order = find(orderId)
        val line = order.lines.firstOrNull { it.id.productId == productId }
            ?: throw BusinessException(ErrorKind.NOT_FOUND, "Product $productId is not in order $orderId")
        order.removeLine(line)
        return order.toResponse()
    }

    private fun addLine(order: Order, request: LineRequest) {
        if (order.lines.any { it.id.productId == request.productId }) {
            throw BusinessException(ErrorKind.CONFLICT, "Product ${request.productId} is already in order ${order.id}")
        }
        val product = findProduct(request.productId)
        order.addLine(OrderLine(OrderLineId(order.id!!, product.id!!), order, product, request.quantity, product.price))
    }

    private fun find(id: Long): Order =
        orders.findById(id).orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "Order $id not found") }

    private fun findProduct(id: Long): Product =
        products.findById(id).orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "Product $id not found") }
}