package com.example.payment.application

import com.example.payment.domain.Payment
import com.example.payment.domain.PaymentRepository
import com.example.payment.domain.PaymentStatus
import com.example.payment.exception.BusinessException
import com.example.payment.exception.ErrorKind
import com.example.payment.messaging.JmsPaymentResults
import org.springframework.stereotype.Service

@Service
class PaymentApplicationService(
    private val paymentRepository: PaymentRepository,
    private val results: JmsPaymentResults
) {

    fun charge(enrollmentId: Long, studentId: String, amount: Int) {
        val declined = studentId == "s-104"
        val reason = if (declined) "Card declined" else null
        paymentRepository.save(Payment(
            enrollmentId,
            studentId,
            amount,
            if(declined) PaymentStatus.FAILED else PaymentStatus.PAID,
            reason
        ))
        results.tell(enrollmentId, !declined, reason)
    }

    fun find(enrollmentId: Long): Payment = paymentRepository.findByEnrollmentId(enrollmentId)
        ?: throw BusinessException(ErrorKind.NOT_FOUND, "Payment not found",
            "No payment for enrollmentId $enrollmentId")
}