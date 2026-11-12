package com.example.enrollment.messaging

data class PaymentRequested(
    val enrollmentId: Long,
    val studentId: String,
    val courseId: String,
    val amount: Int
)
