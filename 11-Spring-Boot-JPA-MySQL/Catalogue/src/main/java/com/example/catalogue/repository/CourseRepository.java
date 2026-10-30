package com.example.catalogue.repository;

import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStatus(CourseStatus status);
    List<Course> findByTitleContainingIgnoreCase(String text);
    List<Course> findByLaunchDateBeforeAndStatusNot(LocalDate date, CourseStatus status);

    @Query("select c from Course c where c.category = :category order by c.launchDate")
    List<Course> jpqlByCategory(@Param("category") String category);

    @Query(value = "select * from courses where category = :category order by launch_date", nativeQuery = true)
    List<Course> nativeByCategory(@Param("category") String category);

    Page<Course> findByStatus(CourseStatus status, Pageable pageable);
}
