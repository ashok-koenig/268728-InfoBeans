package com.example.kotlinspringapp.controller

import com.example.kotlinspringapp.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(private val demoService: DemoService) {
    @GetMapping("/")
    fun greet() = demoService.greet()
//    fun index() = "Welcome to Kotlin Spring App!"

}