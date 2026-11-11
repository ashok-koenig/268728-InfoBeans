package com.example.enrollment.application

import com.example.enrollment.domain.SeatBatch
import com.example.enrollment.domain.SeatBatchRepository
import org.springframework.stereotype.Service

@Service
class EnrollmentApplicationService(private val seats: SeatBatchRepository) {

    fun seatsOf(courseId: String): SeatBatch? = seats.findByCourseId(courseId)
}