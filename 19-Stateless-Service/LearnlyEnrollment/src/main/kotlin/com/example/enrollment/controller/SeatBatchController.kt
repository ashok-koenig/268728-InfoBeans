package com.example.enrollment.controller

import com.example.enrollment.application.EnrollmentApplicationService
import com.example.enrollment.dto.SeatBatchResponse
import com.example.enrollment.dto.toResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seat-batches")
class SeatBatchController(
    private val service: EnrollmentApplicationService
) {

    @GetMapping("/{courseId}")
    fun getSeats(@PathVariable("courseId") courseId: String): ResponseEntity<SeatBatchResponse> {
        val batch = service.seatsOf(courseId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(batch.toResponse())
    }
}