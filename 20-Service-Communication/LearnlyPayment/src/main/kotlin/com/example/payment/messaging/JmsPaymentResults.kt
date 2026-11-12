package com.example.payment.messaging

import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import tools.jackson.databind.json.JsonMapper


@Component
class JmsPaymentResults(private val jms: JmsTemplate, private val json: JsonMapper) {

    fun tell(enrollmentId: Long, paid: Boolean, reason: String?) {
        jms.convertAndSend("payment.results", json.writeValueAsString(
            PaymentResult(enrollmentId, paid, reason)
        ))
    }
}