package com.example.payment.dto

import com.example.payment.domain.Payment

data class PaymentResponse(
    val enrollmentId: Long,
    val studentId: String,
    val amount: Int,
    val status: String,
    val reason: String?
)

fun Payment.toResponse() = PaymentResponse(enrollmentId, studentId, amount, status.name, reason)
