package com.example.enrollment.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app")
data class AppProperties(val instanceName: String, val jwtSecret: String, val tokenMinutes: Long)
