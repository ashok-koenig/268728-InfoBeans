package com.example.shopkart.exception

enum class ErrorKind { NOT_FOUND, CONFLICT, BAD_REQUEST }

class BusinessException(val kind: ErrorKind, message: String) : RuntimeException(message)
