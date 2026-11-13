package com.example.shopkart.config

import jakarta.persistence.EntityManagerFactory
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.hibernate.SessionFactory
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingResponseWrapper

@Component
class StatementCountFilter(entityManagerFactory: EntityManagerFactory) : OncePerRequestFilter() {

    private val statistics = entityManagerFactory.unwrap(SessionFactory::class.java).statistics

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val wrapper = ContentCachingResponseWrapper(response)
        val before = statistics.prepareStatementCount
        chain.doFilter(request, wrapper)
        wrapper.setHeader("X-Statements", (statistics.prepareStatementCount - before).toString())
        wrapper.copyBodyToResponse()
    }
}
