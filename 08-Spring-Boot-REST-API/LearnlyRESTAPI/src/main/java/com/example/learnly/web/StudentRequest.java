package com.example.learnly.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank(message = "name is required")
        @Size(max = 50, message = "name must be at most 50 characters")
        String name,
        @NotBlank(message = "email is required")
        @Email(message = "email must be a valid address")
        String email,
        @NotBlank(message = "city is required")
        String city) {
}
