package com.example.catalogue.repository;

import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStatus(CourseStatus status);
    List<Course> findByTitleContainingIgnoreCase(String text);
    List<Course> findByLaunchDateBeforeAndStatusNot(LocalDate date, CourseStatus status);
}
