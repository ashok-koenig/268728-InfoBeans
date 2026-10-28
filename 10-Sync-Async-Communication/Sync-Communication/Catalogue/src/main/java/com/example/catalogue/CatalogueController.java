package com.example.catalogue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CatalogueController {
    private final Map<String, Course> courses = new ConcurrentHashMap<>(Map.of(
       "JAVA101", new Course("JAVA101", "Java Basic", 25),
       "SPRING201", new Course("SPRING201", "Spring Boot", 10),
       "KOTLIN301", new Course("KOTLIN301", "Kotlin for Java Developers", 0)
    ));

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> find(@PathVariable String id){
        Course course= courses.get(id);
        return course == null? ResponseEntity.notFound().build() : ResponseEntity.ok(course);
    }
}
