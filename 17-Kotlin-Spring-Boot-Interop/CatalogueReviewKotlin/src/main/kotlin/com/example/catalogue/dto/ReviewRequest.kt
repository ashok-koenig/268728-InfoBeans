package com.example.catalogue.dto

data class ReviewRequest(
    val rating: Int,
    val comment: String,
    val anonymous: Boolean
)
