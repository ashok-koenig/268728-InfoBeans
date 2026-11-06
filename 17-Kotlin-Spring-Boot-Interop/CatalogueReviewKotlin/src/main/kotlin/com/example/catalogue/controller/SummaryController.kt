package com.example.catalogue.controller

import com.example.catalogue.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/summary")
class SummaryController(private val courses: CourseService) {

    @GetMapping("/{id}")
    fun summary(@PathVariable id: Long): String {
        val course = courses.get(id)
        return "${course.title} (${course.status}, launches ${course.launchDate})"
    }

}