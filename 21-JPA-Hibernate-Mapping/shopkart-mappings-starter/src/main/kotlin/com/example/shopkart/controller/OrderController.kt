package com.example.shopkart.controller

import com.example.shopkart.dto.LineRequest
import com.example.shopkart.dto.OrderRequest
import com.example.shopkart.dto.OrderResponse
import com.example.shopkart.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val service: OrderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: OrderRequest): OrderResponse = service.create(request)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): OrderResponse = service.get(id)

    @PostMapping("/{id}/lines")
    fun addLine(@PathVariable id: Long, @RequestBody request: LineRequest): OrderResponse =
        service.addLine(id, request)

    @DeleteMapping("/{orderId}/lines/{productId}")
    fun removeLine(@PathVariable orderId: Long, @PathVariable productId: Long): OrderResponse =
        service.removeLine(orderId, productId)
}