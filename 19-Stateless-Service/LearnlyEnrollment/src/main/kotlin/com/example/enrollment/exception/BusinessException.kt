package com.example.enrollment.exception

class BusinessException(val kind: ErrorKind, val title: String, val detail: String) : RuntimeException(detail)