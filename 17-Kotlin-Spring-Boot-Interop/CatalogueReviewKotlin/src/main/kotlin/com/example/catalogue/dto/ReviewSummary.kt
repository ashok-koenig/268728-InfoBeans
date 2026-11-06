package com.example.catalogue.dto

data class ReviewSummary(
    val courseId: Long,
    val count: Int,
    val average: Double,
    val histogram: Map<Int, Int>
)
