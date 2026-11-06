package com.example.catalogue.controller

import com.example.catalogue.dto.ReviewRequest
import com.example.catalogue.dto.ReviewResponse
import com.example.catalogue.service.ReviewService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewService: ReviewService,
) {

    @PostMapping("/api/courses/{courseId}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@PathVariable("courseId") courseId: Long,
              @Valid @RequestBody request: ReviewRequest
    ) = reviewService.add(courseId, request)

    @GetMapping("/api/courses/{courseId}/reviews")
    fun list(@PathVariable("courseId") courseId: Long) =
        reviewService.list(courseId)
    
    @GetMapping("/api/reviews/{id}")
    fun get(@PathVariable("id") id: Long) = reviewService.get(id)
}