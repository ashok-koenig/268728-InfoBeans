package com.example.catalogue.controller;

import com.example.catalogue.dto.CourseRequest;
import com.example.catalogue.dto.CourseResponse;
import com.example.catalogue.entity.CourseStatus;
import com.example.catalogue.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseResponse> create(@Valid @RequestBody CourseRequest request){
        CourseResponse created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public List<CourseResponse> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CourseResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public CourseResponse update(@PathVariable Long id,@Valid @RequestBody CourseRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/search/by-status")
    public List<CourseResponse> byStatus(@RequestParam CourseStatus status){
        return service.byStatus(status);
    }

    @GetMapping("/search/by-title")
    public List<CourseResponse> byTitle(@RequestParam String text){
        return service.byTitle(text);
    }

    @GetMapping("/search/launched-before")
    public List<CourseResponse> launchedBefore(@RequestParam LocalDate date){
        return service.launchBefore(date);
    }

    @GetMapping("/search/jpql")
    public List<CourseResponse> jpqlQuery(@RequestParam String category){
        return service.jpqlQuery(category);
    }

    @GetMapping("/search/native")
    public List<CourseResponse> nativeQuery(@RequestParam String category){
        return service.nativeQuery(category);
    }
}
