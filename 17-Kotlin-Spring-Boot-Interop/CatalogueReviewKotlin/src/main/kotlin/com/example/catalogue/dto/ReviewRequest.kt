package com.example.catalogue.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ReviewRequest(
     @field:Min(1) @field:Max(5) val rating: Int,
    @field:NotBlank @field:Size(max = 500) val comment: String,
    val anonymous: Boolean
)
