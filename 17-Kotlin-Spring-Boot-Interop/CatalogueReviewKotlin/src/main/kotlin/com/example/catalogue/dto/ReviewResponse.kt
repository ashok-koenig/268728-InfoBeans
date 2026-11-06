package com.example.catalogue.dto

data class ReviewResponse(
    val courseId: Long,
    val rating: Int,
    val comment: String,
    val reviewer: String
)