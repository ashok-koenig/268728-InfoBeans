package com.example.learnly.routing;

import com.example.learnly.model.Course;
import com.example.learnly.model.Level;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> list(@RequestParam(required = false) Level level,
                             @RequestParam(defaultValue = "10") int limit) {
        return service.list(level, limit);
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable long id){
        return service.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody CreateCourseRequest request){
        return service.add(request);
    }
}
