package com.example.shopkart.exception

import com.example.shopkart.dto.ErrorResponse
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun business(e: BusinessException): ResponseEntity<ErrorResponse> {
        val status = when (e.kind) {
            ErrorKind.NOT_FOUND -> HttpStatus.NOT_FOUND
            ErrorKind.CONFLICT -> HttpStatus.CONFLICT
            ErrorKind.BAD_REQUEST -> HttpStatus.BAD_REQUEST
        }
        return ResponseEntity.status(status).body(ErrorResponse(e.kind.name, e.message))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun invalid(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = e.bindingResult.fieldErrors.joinToString { "${it.field} ${it.defaultMessage}" }
        return ResponseEntity.badRequest().body(ErrorResponse("BAD_REQUEST", message))
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun integrity(e: DataIntegrityViolationException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.CONFLICT)
            .body(ErrorResponse("CONFLICT", e.mostSpecificCause.message))
}
