package com.example.enrollment.messaging

data class PaymentResult(
    val enrollmentId: Long,
    val paid: Boolean,
    val reason: String?
)
