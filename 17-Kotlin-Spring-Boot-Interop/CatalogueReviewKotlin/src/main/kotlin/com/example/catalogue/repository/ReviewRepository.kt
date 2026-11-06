package com.example.catalogue.repository

import com.example.catalogue.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
    fun findByCourseId(courseId: Long): List<Review>
    fun countByCourseId(courseId: Long): Long
}