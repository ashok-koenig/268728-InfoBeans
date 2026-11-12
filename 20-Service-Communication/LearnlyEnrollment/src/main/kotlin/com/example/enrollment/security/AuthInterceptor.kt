package com.example.enrollment.security

import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthInterceptor(private val tokens: TokenService) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val header = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer ")) {
            throw BusinessException(ErrorKind.UNAUTHORIZED, "Unauthorized", "Send a token in the Authorization header: Bearer <token>")
        }
        val user = tokens.verify(header.substring(7))
            ?: throw BusinessException(ErrorKind.UNAUTHORIZED, "Unauthorized", "The token is invalid or expired")
        request.setAttribute("auth", user)
        return true
    }
}
