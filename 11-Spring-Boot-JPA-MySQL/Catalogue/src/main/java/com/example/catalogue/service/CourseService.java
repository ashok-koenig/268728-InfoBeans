package com.example.catalogue.service;

import com.example.catalogue.dto.CourseRequest;
import com.example.catalogue.dto.CourseResponse;
import com.example.catalogue.dto.PageResponse;
import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;
import com.example.catalogue.exception.CourseNotFoundException;
import com.example.catalogue.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public PageResponse<CourseResponse> findAll(Pageable pageable) {
        Page<Course> page = repository.findAll(pageable);
        return PageResponse.from(page.map(CourseResponse::from));
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

    public PageResponse<CourseResponse> byStatus(CourseStatus status, Pageable pageable){
        Page<Course> page = repository.findByStatus(status, pageable);
        return PageResponse.from(page.map(CourseResponse::from));
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

    public List<CourseResponse> jpqlQuery(String category){
        return map(repository.jpqlByCategory(category));
    }

    public List<CourseResponse> nativeQuery(String category){
        return map(repository.nativeByCategory(category));
    }
}
