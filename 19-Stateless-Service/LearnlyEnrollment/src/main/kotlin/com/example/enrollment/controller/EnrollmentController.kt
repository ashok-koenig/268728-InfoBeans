package com.example.enrollment.controller

import com.example.enrollment.application.EnrollmentApplicationService
import com.example.enrollment.domain.Enrollment
import com.example.enrollment.dto.EnrollmentRequest
import com.example.enrollment.dto.EnrollmentResponse
import com.example.enrollment.dto.toResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/enrollments")
class EnrollmentController(private val service: EnrollmentApplicationService) {

    @PostMapping
    fun enroll(@Valid @RequestBody request: EnrollmentRequest): ResponseEntity<EnrollmentResponse> {
        val saved = service.enroll(request.studentId, request.courseId)
        return ResponseEntity.created(URI.create("/enrollments/${saved.id}")).body(saved.toResponse())
    }

}