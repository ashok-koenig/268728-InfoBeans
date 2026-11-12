package com.example.enrollment.dto

import jakarta.validation.constraints.NotBlank

data class EnrollmentRequest(
    @field:NotBlank val courseId: String,
)
