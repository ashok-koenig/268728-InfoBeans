package com.example.payment.messaging

import com.example.payment.application.PaymentApplicationService
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import tools.jackson.databind.json.JsonMapper

@Component
class PaymentRequestListener(
    private val service: PaymentApplicationService,
    private val json: JsonMapper
) {

    @JmsListener(destination = "payment.requests")
    fun onRequest(text: String){
        val request = json.readValue(text, PaymentRequest::class.java)
        service.charge(request.enrollmentId, request.studentId, request.amount)
    }
}