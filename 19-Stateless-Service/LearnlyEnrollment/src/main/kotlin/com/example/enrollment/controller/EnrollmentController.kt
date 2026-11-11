package com.example.enrollment.controller

import com.example.enrollment.application.EnrollmentApplicationService
import com.example.enrollment.domain.Enrollment
import com.example.enrollment.dto.EnrollmentRequest
import com.example.enrollment.dto.EnrollmentResponse
import com.example.enrollment.dto.PageResponse
import com.example.enrollment.dto.toResponse
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = service.find(id).toResponse()

    @GetMapping
    fun list(
        @RequestParam studentId: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
    ): PageResponse<EnrollmentResponse> {
        val found = service.listOf(studentId, PageRequest.of(page, size))
        return PageResponse(found.content.map { it.toResponse() },
            page, size, found.totalElements)
    }

    @DeleteMapping("/{id}")
    fun cancel(@PathVariable id: Long): ResponseEntity<Void> {
        service.cancel(id)
        return ResponseEntity.noContent().build()
    }

}