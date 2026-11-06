package com.example.catalogue.service

import com.example.catalogue.dto.ReviewRequest
import com.example.catalogue.dto.ReviewResponse
import com.example.catalogue.dto.ReviewSummary
import com.example.catalogue.dto.toResponse
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
        return reviewRepository.save(Review( courseId,
            request.rating, request.comment, reviewer)).toResponse()
    }

    fun list(courseId: Long): List<ReviewResponse> {
        courseService.get(courseId)
        return reviewRepository.findByCourseId(courseId). map(Review::toResponse)
    }

    fun get(id: Long): ReviewResponse =
        reviewRepository.findByIdOrNull(id)?.toResponse() ?: throw ReviewNotFoundException(id)

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