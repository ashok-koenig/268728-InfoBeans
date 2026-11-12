package com.example.catalogue.dto;

import com.example.catalogue.entity.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CourseRequest(
        @NotBlank @Size(max = 120)
        String title,
        @NotNull
        CourseStatus status,
        @NotNull
        LocalDate launchDate,
        @NotBlank @Size(max = 60)
        String category
) {
}
