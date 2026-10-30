package com.example.catalogue.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @Column(nullable = false)
    private LocalDate launchDate;

    private String category;

    public Course() {
    }


}
