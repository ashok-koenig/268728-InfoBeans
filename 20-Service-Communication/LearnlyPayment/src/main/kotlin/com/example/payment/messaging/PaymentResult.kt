package com.example.payment.messaging

data class PaymentResult(val enrollmentId: Long,
                         val paid: Boolean,
                         val reason: String?)
