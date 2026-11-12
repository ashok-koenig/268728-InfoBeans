package com.example.enrollment.dto

data class PageResponse<T>(val items: List<T>, val page: Int, val size: Int, val total: Long)
