package com.example.catalogue.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "learnly.reviews")
data class ReviewProperties(val maxPerCourse: Int = 3)
