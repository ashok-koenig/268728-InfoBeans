package com.example.enrollment.messaging


import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import tools.jackson.databind.json.JsonMapper

@Component
class JmsPaymentRequests(
    private val jms: JmsTemplate,
    private val json: JsonMapper
) {
    fun ask(enrollmentId: Long, studentId: String, courseId: String, amount: Int) {
        val message = PaymentRequested(enrollmentId, studentId, courseId, amount)
        jms.convertAndSend("payment.requests",
            json.writeValueAsString(message))
    }
}