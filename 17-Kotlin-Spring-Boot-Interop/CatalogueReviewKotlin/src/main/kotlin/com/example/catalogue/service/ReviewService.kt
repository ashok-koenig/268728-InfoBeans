package com.example.catalogue.service

import com.example.catalogue.dto.ReviewRequest
import com.example.catalogue.dto.ReviewResponse
import com.example.catalogue.dto.ReviewSummary
import com.example.catalogue.entity.Review
import com.example.catalogue.exception.ReviewNotFoundException
import com.example.catalogue.repository.ReviewRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val courseService: CourseService,
) {
    fun add(courseId: Long, request: ReviewRequest): ReviewResponse {
        courseService.get(courseId)
        val reviewer = if (request.anonymous) "anonymous" else "student"
        val saved = reviewRepository.save(Review( courseId,
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

    fun get(id: Long): ReviewResponse =
        reviewRepository.findByIdOrNull(id)?.let {
            ReviewResponse(it.id, it.courseId, it.rating, it.comment, it.reviewer)
        } ?: throw ReviewNotFoundException(id)

    fun summary (courseId: Long) : ReviewSummary {
        courseService.get(courseId)
        val ratings = reviewRepository.findByCourseId(courseId).map {it.rating}

        return ReviewSummary(
            courseId = courseId,
            count = ratings.size,
            average = if(ratings.isNotEmpty()) ratings.average() else 0.0,
            histogram = (1..5).associateWith { r -> ratings.count { it == r } }
        )
    }
}