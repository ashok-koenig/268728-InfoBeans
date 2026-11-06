package com.example.catalogue.exception

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
class ReviewErrors {

    @ExceptionHandler(ReviewNotFoundException::class)
    fun notFound(ex: ReviewNotFoundException): ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
            ex.message ?: "Review not found").apply {
                title = "Review not found"
        }

    @ExceptionHandler(ReviewLimitExceededException::class)
    fun limitExceeded(ex: ReviewLimitExceededException): ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
            ex.message ?: "Too many reviews").apply {
            title = "Too many reviews"
        }
}