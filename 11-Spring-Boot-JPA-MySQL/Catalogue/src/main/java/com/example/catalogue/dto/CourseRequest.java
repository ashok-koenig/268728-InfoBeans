package com.example.catalogue.dto;

import com.example.catalogue.entity.CourseStatus;

import java.time.LocalDate;

public record CourseRequest(String title, CourseStatus status, LocalDate launchDate, String category) {
}
