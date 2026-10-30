package com.example.catalogue.dto;

import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;

import java.time.LocalDate;

public record CourseResponse(Long id, String title, CourseStatus status, LocalDate launchDate, String category) {

    public static CourseResponse from(Course course){
        return new CourseResponse(course.getId(), course.getTitle(),
                course.getStatus(), course.getLaunchDate(), course.getCategory());
    }
}
