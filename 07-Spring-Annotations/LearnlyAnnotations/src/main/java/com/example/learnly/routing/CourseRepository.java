package com.example.learnly.routing;

import com.example.learnly.model.Course;
import com.example.learnly.model.SampleData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>(SampleData.courses());
    private long nextId = 5;

    public List<Course> findAll() {
        return List.copyOf(courses);
    }

    public Optional<Course> findById(long id){
        return courses.stream().filter(course -> course.id() == id).findFirst();
    }

    public Course save(Course course){
        Course saved = new Course(nextId++, course.title(), course.level(), course.price());
        courses.add(saved);
        return saved;
    }

    public boolean deleteById(long id){
        return courses.removeIf(course -> course.id() == id);
    }
}
