package com.example.enrollment.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ProblemDetail> {
        val status = statusOf(e.kind)
        val problem = ProblemDetail.forStatusAndDetail(status, e.message)
        problem.title = e.title
        return ResponseEntity.status(status).body(problem)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleInvalid(e: MethodArgumentNotValidException): ResponseEntity<ProblemDetail> {
        val detail = e.bindingResult.fieldErrors.map {"${it.field} ${it.defaultMessage}"}
            .firstOrNull() ?: "invalid request"
        val problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detail)
        problem.title = "Invalid request"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem)
    }


    private fun statusOf(kind: ErrorKind): HttpStatus = when(kind) {
        ErrorKind.NOT_FOUND -> HttpStatus.NOT_FOUND
        ErrorKind.CONFLICT -> HttpStatus.CONFLICT
        ErrorKind.BAD_REQUEST -> HttpStatus.BAD_REQUEST
        ErrorKind.UNAUTHORIZED -> HttpStatus.UNAUTHORIZED
        ErrorKind.FORBIDDEN -> HttpStatus.FORBIDDEN
        ErrorKind.UNAVAILABLE -> HttpStatus.SERVICE_UNAVAILABLE
    }
}