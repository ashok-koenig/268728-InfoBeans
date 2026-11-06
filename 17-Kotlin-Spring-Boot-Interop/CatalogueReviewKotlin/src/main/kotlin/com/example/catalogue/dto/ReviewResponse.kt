package com.example.catalogue.dto

data class ReviewResponse(
    val id: Long?,
    val courseId: Long,
    val rating: Int,
    val comment: String,
    val reviewer: String
)