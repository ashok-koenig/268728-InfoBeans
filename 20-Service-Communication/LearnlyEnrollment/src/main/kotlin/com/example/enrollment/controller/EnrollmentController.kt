package com.example.enrollment.controller

import com.example.enrollment.application.EnrollmentApplicationService
import com.example.enrollment.domain.Enrollment
import com.example.enrollment.dto.EnrollmentRequest
import com.example.enrollment.dto.EnrollmentResponse
import com.example.enrollment.dto.PageResponse
import com.example.enrollment.dto.toResponse
import com.example.enrollment.security.AuthUser
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/enrollments")
class EnrollmentController(private val service: EnrollmentApplicationService) {

    @PostMapping
    fun enroll(
        @RequestAttribute("auth") auth: AuthUser,
        @Valid @RequestBody request: EnrollmentRequest
    ): ResponseEntity<EnrollmentResponse> {
        val saved = service.enroll(auth.student, request.courseId)
        return ResponseEntity.created(URI.create("/enrollments/${saved.id}")).body(saved.toResponse())
    }

    @GetMapping("/{id}")
    fun get(@RequestAttribute("auth") auth: AuthUser,@PathVariable id: Long) =
        service.find(id, auth.student, auth.isAdmin).toResponse()

    @GetMapping
    fun list(
        @RequestAttribute("auth") auth: AuthUser,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
    ): PageResponse<EnrollmentResponse> {
        val found = service.listOf(auth.student, PageRequest.of(page, size))
        return PageResponse(found.content.map { it.toResponse() },
            page, size, found.totalElements)
    }

    @DeleteMapping("/{id}")
    fun cancel(@RequestAttribute("auth") auth: AuthUser,@PathVariable id: Long): ResponseEntity<Void> {
        service.cancel(id, auth.student, auth.isAdmin)
        return ResponseEntity.noContent().build()
    }

}