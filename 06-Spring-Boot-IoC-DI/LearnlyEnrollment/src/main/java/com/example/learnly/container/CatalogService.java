package com.example.learnly.container;

import com.example.learnly.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    private final CourseRepository repository;

    public CatalogService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<String> titles(){
        return repository.findAll().stream().map(Course::title).toList();
    }
}
