package com.example.catalogue.dto

import com.example.catalogue.entity.Review

fun Review.toResponse() = ReviewResponse(id, courseId, rating, comment, reviewer)