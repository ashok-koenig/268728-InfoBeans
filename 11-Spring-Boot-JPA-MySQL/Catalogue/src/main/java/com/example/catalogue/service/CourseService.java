package com.example.catalogue.service;

import com.example.catalogue.dto.CourseRequest;
import com.example.catalogue.dto.CourseResponse;
import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;
import com.example.catalogue.exception.CourseNotFoundException;
import com.example.catalogue.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public CourseResponse get(Long id){
        return repository.findById(id).map(CourseResponse::from).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public CourseResponse update(Long id, CourseRequest request){
        Course course = repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        course.setTitle(request.title());
        course.setStatus(request.status());
        course.setLaunchDate(request.launchDate());
        course.setCategory(request.category());
        return CourseResponse.from(repository.save(course));
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new CourseNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public List<CourseResponse> byStatus(CourseStatus status){
        return map(repository.findByStatus(status));
    }

    public List<CourseResponse> byTitle(String text){
        return map(repository.findByTitleContainingIgnoreCase(text));
    }

    public List<CourseResponse> launchBefore(LocalDate date) {
        return map(repository.findByLaunchDateBeforeAndStatusNot(date, CourseStatus.ARCHIVED));
    }

    private List<CourseResponse> map(List<Course> list){
        return list.stream().map(CourseResponse::from).toList();
    }
}
