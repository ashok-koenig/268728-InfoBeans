package com.example.learnly.model;

import java.math.BigDecimal;
import java.util.List;

public final class SampleData {

    private SampleData() {
    }

    public static List<Course> courses() {
        return List.of(
                new Course(1, "Java Foundations", Level.BEGINNER, new BigDecimal("4999.00")),
                new Course(2, "Spring Boot Essentials", Level.INTERMEDIATE, new BigDecimal("7999.00")),
                new Course(3, "SQL in a Week", Level.BEGINNER, new BigDecimal("2999.00")),
                new Course(4, "Microservices Design", Level.ADVANCED, new BigDecimal("9999.00")));
    }
}