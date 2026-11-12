package com.example.payment.exception

enum class ErrorKind { NOT_FOUND }

class BusinessException(val kind: ErrorKind, val title: String, val detail: String) : RuntimeException(detail)