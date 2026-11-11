package com.example.enrollment.controller

import com.example.enrollment.security.TokenService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// A stand-in for the Identity service, which issues tokens in the Learnly design.
@RestController
class DevTokenController(private val tokens: TokenService) {

    @PostMapping("/dev/tokens")
    fun issue(@RequestParam student: String, @RequestParam(defaultValue = "STUDENT") role: String) = tokens.issue(student, role)
}
