package com.example.enrollment.adapter

import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind
import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.retry.annotation.Retry
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClientException

data class CourseInfo(val courseId: String, val title: String, val price: Int, val open: Boolean)

@Component
class CatalogueAdapter(private val client: CatalogueClient) {

    @Retry(name = "catalogue", fallbackMethod = "unknownOrUnavailable")
    @CircuitBreaker(name = "catalogue")
    fun find(courseId: String): CourseInfo? {
        return try {
            val course = client.get(courseId)
            CourseInfo(courseId, course.title, course.price, course.status == "PUBLISHED")
        }catch (e: HttpClientErrorException.NotFound){
            null
        } catch (e: RestClientException) {
            throw BusinessException(ErrorKind.UNAVAILABLE, "Catalogue unavailable",
                "The course catalogue does not exist, try again later.")
        }
    }

    private fun unknownOrUnavailable(courseId: String, e: HttpClientErrorException.NotFound):
            CourseInfo? = null

    private fun unknownOrUnavailable(courseId: String, e: CallNotPermittedException):
            CourseInfo? = throw BusinessException(ErrorKind.UNAVAILABLE, "Catalogue paused",
        "Too many failures, no call was made, Try again in a few seconds.")

    private fun unknownOrUnavailable(courseId: String, e: Throwable):
            CourseInfo? = throw BusinessException(ErrorKind.UNAVAILABLE, "Catalogue unavailable",
        "The course catalogue cannot answer now, try again soon")
}