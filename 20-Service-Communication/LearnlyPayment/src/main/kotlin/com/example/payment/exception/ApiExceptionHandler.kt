package com.example.payment.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ProblemDetail> {

        val problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.message)
        problem.title = e.title
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem)
    }
}