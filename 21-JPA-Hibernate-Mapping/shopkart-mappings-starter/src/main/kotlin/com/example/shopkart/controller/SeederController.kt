package com.example.shopkart.controller

import com.example.shopkart.service.SeederService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seed")
class SeederController(
    private val seeder: SeederService
) {
    @GetMapping("/{count}")
    fun seed(@PathVariable("count") count: Int): Map<String, Int> =
        mapOf("seeded" to seeder.seedProducts(count))
}