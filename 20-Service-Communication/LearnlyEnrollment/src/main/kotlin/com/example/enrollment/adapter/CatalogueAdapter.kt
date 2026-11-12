package com.example.enrollment.adapter

import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClientException

data class CourseInfo(val courseId: String, val title: String, val price: Int, val open: Boolean)

class CatalogueAdapter(private val client: CatalogueClient) {
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
}