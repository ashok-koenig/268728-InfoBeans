package com.example.payment.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
class Payment(
    val enrollmentId: Long,
    val studentId: String,
    val amount: Int,
    @Enumerated(EnumType.STRING)
    val status: PaymentStatus,
    val reason: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    val createdAt: Instant = Instant.now()
}