package com.example.learnly.routing;

import com.example.learnly.model.Course;
import com.example.learnly.model.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> list(Level level, int limit){
        return repository.findAll().stream()
                .filter(course -> level == null || course.level() == level)
                .limit(limit)
                .toList();
    }

    public Course find(long id){
        return repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public Course add(CreateCourseRequest request){
        return repository.save(new Course(0, request.title(), request.level(), request.price()));
    }

    public void remove(long id){
        if(!repository.deleteById(id)){
            throw new CourseNotFoundException(id);
        }
    }
}
