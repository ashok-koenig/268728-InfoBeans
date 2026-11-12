package com.example.enrollment.dto

import com.example.enrollment.domain.Enrollment

data class EnrollmentResponse(
    val id: Long?,
    val studentId: String,
    val courseId: String,
    val status: String
)

fun Enrollment.toResponse() = EnrollmentResponse(id, studentId, courseId, status.name)