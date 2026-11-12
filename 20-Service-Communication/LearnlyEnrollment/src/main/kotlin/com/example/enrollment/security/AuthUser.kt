package com.example.enrollment.security

import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind

data class AuthUser(val student: String, val role: String) {

    val isAdmin: Boolean
        get() = role == "ADMIN"

    fun requireAdmin(what: String) {
        if (!isAdmin) {
            throw BusinessException(ErrorKind.FORBIDDEN, "Forbidden", "Only an administrator can $what")
        }
    }
}
