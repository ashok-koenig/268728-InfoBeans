package com.example.learnly.routing;

import com.example.learnly.model.Level;

import java.math.BigDecimal;

public record CreateCourseRequest(String title, Level level, BigDecimal price) {
}
