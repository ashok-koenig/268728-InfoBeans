package com.example.catalogue.controller

import org.springframework.boot.SpringBootVersion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/about")
class AboutController {

    @GetMapping
    fun about() = mapOf(
        "kotlin" to KotlinVersion.CURRENT.toString(),
        "springBoot" to SpringBootVersion.getVersion()
    )
}