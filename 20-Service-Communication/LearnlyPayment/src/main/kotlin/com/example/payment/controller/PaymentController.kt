package com.example.payment.controller

import com.example.payment.application.PaymentApplicationService
import com.example.payment.dto.PaymentResponse
import com.example.payment.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(
    private val service: PaymentApplicationService
) {

    @GetMapping("/{enrollmentId}")
    fun get(@PathVariable enrollmentId: Long) = service.find(enrollmentId).toResponse()

}