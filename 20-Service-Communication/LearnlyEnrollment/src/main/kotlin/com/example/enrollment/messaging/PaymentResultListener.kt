package com.example.enrollment.messaging

import com.example.enrollment.application.EnrollmentApplicationService
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import tools.jackson.databind.json.JsonMapper

@Component
class PaymentResultListener(
    private val service: EnrollmentApplicationService,
    private val json: JsonMapper
) {

    @JmsListener(destination = "payment.results")
    fun onResult(text: String){
        val result = json.readValue(text, PaymentResult::class.java)
        service.paymentResult(result.enrollmentId, result.paid)
    }
}