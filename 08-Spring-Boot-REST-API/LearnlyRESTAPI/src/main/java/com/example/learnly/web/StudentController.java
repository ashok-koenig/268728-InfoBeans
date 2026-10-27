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
    public List<Student> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable long id){
        return service.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student saved = service.create(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> replace(@PathVariable long id, @RequestBody Student student){
        return service.replace(id, student)
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
