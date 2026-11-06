package com.example.catalogue.service

import com.example.catalogue.dto.ReviewRequest
import com.example.catalogue.dto.ReviewResponse
import com.example.catalogue.entity.Review
import com.example.catalogue.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val courseService: CourseService,
) {
    fun add(courseId: Long, request: ReviewRequest): ReviewResponse {
        courseService.get(courseId)
        val reviewer = if (request.anonymous) "anonymous" else "student"
        val saved = reviewRepository.save(Review(courseId = courseId,
            request.rating, request.comment, reviewer))
        return ReviewResponse(saved.id, saved.courseId,
            saved.rating, saved.comment, saved.reviewer)
    }

    fun list(courseId: Long): List<ReviewResponse> {
        courseService.get(courseId)
        return reviewRepository.findByCourseId(courseId). map {
            ReviewResponse(it.id, it.courseId, it.rating, it.comment, it.reviewer)
        }
    }
}