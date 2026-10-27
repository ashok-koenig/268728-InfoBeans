package com.example.learnly.web;

import com.example.learnly.model.Student;
import com.example.learnly.service.StudentService;
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
    public ResponseEntity<StudentResponse> get(@PathVariable long id){
        return service.find(id).map(StudentMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request){
        Student saved = service.create(StudentMapper.toEntity(request));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(StudentMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> replace(@PathVariable long id,
                                                   @RequestBody StudentRequest request){
        return service.replace(id, StudentMapper.toEntity(request))
                .map(StudentMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        if(!service.delete(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
