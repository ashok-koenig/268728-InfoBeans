package com.example.shopkart.service

import com.example.shopkart.dto.ProductRequest
import com.example.shopkart.dto.ProductResponse
import com.example.shopkart.dto.toEntity
import com.example.shopkart.dto.toResponse
import com.example.shopkart.exception.BusinessException
import com.example.shopkart.exception.ErrorKind
import com.example.shopkart.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun create(request: ProductRequest): ProductResponse
    = productRepository.save(request.toEntity()).toResponse()

    fun list(): List<ProductResponse> = productRepository.findAll().map { it.toResponse() }

    fun get(id: Long): ProductResponse =
        productRepository.findById(id)
            .orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "product $id not found") }
            .toResponse()
}