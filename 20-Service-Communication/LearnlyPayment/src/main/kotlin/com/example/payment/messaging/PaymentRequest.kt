package com.example.payment.messaging

data class PaymentRequest(
    val enrollmentId: Long,
    val studentId: String,
    val courseId: String,
    val amount: Int)