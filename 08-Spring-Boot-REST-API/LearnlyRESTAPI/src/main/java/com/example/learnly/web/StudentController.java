package com.example.learnly.web;

import com.example.learnly.model.Student;
import com.example.learnly.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentResponse> list(){
        return service.findAll().stream().map(StudentMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public StudentResponse get(@PathVariable long id){
        return StudentMapper.toResponse(service.find(id));
    }
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request){
        Student saved = service.create(StudentMapper.toEntity(request));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(StudentMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public StudentResponse replace(@PathVariable long id,
                                                   @Valid @RequestBody StudentRequest request){
        return StudentMapper.toResponse(service.replace(id, StudentMapper.toEntity(request)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        return ResponseEntity.noContent().build();
    }
}
