package com.example.catalogue.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ReviewErrors {

    @ExceptionHandler(ReviewNotFoundException::class)
    fun notFound(ex: ReviewNotFoundException): ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
            ex.message ?: "Review not found").apply {
                title = "Review not found"
        }
}