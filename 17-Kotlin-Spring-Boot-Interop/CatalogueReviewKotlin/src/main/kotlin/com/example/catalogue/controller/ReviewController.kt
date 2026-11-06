package com.example.catalogue.controller

import com.example.catalogue.dto.ReviewRequest
import com.example.catalogue.dto.ReviewResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController {

    @PostMapping("/api/courses/{courseId}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@PathVariable("courseId") courseId: Long,
              @Valid @RequestBody request: ReviewRequest
    ) = ReviewResponse(courseId,
        request.rating,
        request.comment,
        if (request.anonymous) "anonymous" else "student")
}