package com.example.enrollment.controller

import com.example.enrollment.dto.AuthResponse
import com.example.enrollment.dto.toResponse
import com.example.enrollment.security.AuthUser
import com.example.enrollment.security.TokenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// A stand-in for the Identity service, which issues tokens in the Learnly design.
@RestController
class DevTokenController(private val tokens: TokenService) {

    @GetMapping("/me")
    fun me(@RequestAttribute("auth") auth: AuthUser): AuthResponse  = auth.toResponse()

    @PostMapping("/dev/tokens")
    fun issue(@RequestParam student: String, @RequestParam(defaultValue = "STUDENT") role: String)
    = tokens.issue(student, role)
}
