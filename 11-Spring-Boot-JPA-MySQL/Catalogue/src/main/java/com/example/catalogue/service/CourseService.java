package com.example.catalogue.service;

import com.example.catalogue.dto.CourseRequest;
import com.example.catalogue.dto.CourseResponse;
import com.example.catalogue.entity.Course;
import com.example.catalogue.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseResponse create(CourseRequest request){
        Course course = new Course(request.title(), request.status(), request.launchDate(), request.category());
        return CourseResponse.from(repository.save(course));
    }

    public List<CourseResponse> findAll() {
        return repository.findAll().stream().map(CourseResponse::from).toList();
    }
}
