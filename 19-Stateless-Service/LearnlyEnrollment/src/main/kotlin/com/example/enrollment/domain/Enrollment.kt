package com.example.enrollment.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
class Enrollment(
    val studentId: String,
    val courseId: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: EnrollmentStatus = EnrollmentStatus.CONFIRMED

    val createdAt: Instant = Instant.now()

    fun cancel(): Boolean {
        if(status == EnrollmentStatus.CANCELLED)
            return false
        status = EnrollmentStatus.CANCELLED
        return true
    }
}