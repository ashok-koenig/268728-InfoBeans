package com.example.enrollment.application

import com.example.enrollment.domain.SeatBatch
import com.example.enrollment.domain.SeatBatchRepository
import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind
import org.springframework.stereotype.Service

@Service
class EnrollmentApplicationService(private val seats: SeatBatchRepository) {

    fun seatsOf(courseId: String): SeatBatch = seats.findByCourseId(courseId)
        ?: throw BusinessException(ErrorKind.NOT_FOUND, "Course not found", "No seats are kept for course $courseId")
}