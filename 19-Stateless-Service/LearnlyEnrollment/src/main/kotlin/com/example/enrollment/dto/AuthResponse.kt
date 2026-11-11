package com.example.enrollment.dto

import com.example.enrollment.security.AuthUser

data class AuthResponse(val student: String, val role: String, val admin: Boolean)

fun AuthUser.toResponse() =  AuthResponse(student, role , isAdmin)