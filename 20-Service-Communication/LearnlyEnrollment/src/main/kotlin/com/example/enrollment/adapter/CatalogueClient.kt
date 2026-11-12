package com.example.enrollment.adapter

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

data class CatalogueCourse(val id: Long, val title: String, val status: String, val price: Int)

@HttpExchange("/api/courses")
interface CatalogueClient {

    @GetExchange("/{id}")
    fun get(@PathVariable id: String): CatalogueCourse
}