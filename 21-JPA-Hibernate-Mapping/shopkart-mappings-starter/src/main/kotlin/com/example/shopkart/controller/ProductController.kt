package com.example.shopkart.controller

import com.example.shopkart.dto.ProductRequest
import com.example.shopkart.dto.ProductResponse
import com.example.shopkart.dto.ProductSummaryResponse
import com.example.shopkart.dto.TagRequest
import com.example.shopkart.entity.Product
import com.example.shopkart.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ProductRequest): ProductResponse =
        productService.create(request)

    @GetMapping
    fun list(): List<ProductResponse> = productService.list()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ProductResponse = productService.get(id)

    @PostMapping("/{id}/tags")
    fun addTags(@PathVariable id: Long, @RequestBody request: TagRequest): ProductResponse =
        productService.addTag(id, request)

    @GetMapping("/search")
    fun search(@RequestParam category: String, @RequestParam maxPrice: BigDecimal):
            List<ProductSummaryResponse> = productService.search(category, maxPrice)
}