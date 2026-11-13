package com.example.shopkart.service

import com.example.shopkart.dto.ProductRequest
import com.example.shopkart.dto.ProductResponse
import com.example.shopkart.dto.ProductSummaryResponse
import com.example.shopkart.dto.TagRequest
import com.example.shopkart.dto.toEntity
import com.example.shopkart.dto.toResponse
import com.example.shopkart.dto.toSummary
import com.example.shopkart.entity.Product
import com.example.shopkart.entity.Tag
import com.example.shopkart.exception.BusinessException
import com.example.shopkart.exception.ErrorKind
import com.example.shopkart.repository.ProductRepository
import com.example.shopkart.repository.TagRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val tagRepository: TagRepository,
) {

    fun create(request: ProductRequest): ProductResponse
    = productRepository.save(request.toEntity()).toResponse()

    fun list(): List<ProductResponse> = productRepository.findAll().map { it.toResponse() }

    fun get(id: Long): ProductResponse = find(id)
            .toResponse()

    @Transactional
    fun addTag(id: Long, request: TagRequest): ProductResponse {
        val product = find(id)
        val tag = tagRepository.findByName(request.name) ?: tagRepository.save(Tag(request.name))
        product.tags.add(tag)
        return product.toResponse()
    }

    private fun find(id: Long): Product =
        productRepository.findById(id).orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "product $id not found") }

    fun search(category: String, maxPrice: BigDecimal): List<ProductSummaryResponse> =
        productRepository.findByCategoryAndPriceAmountLessThanEqual(
            category,
            maxPrice,
            PageRequest.of(0,20)
        ).map { it.toSummary() }
}