package com.example.learnly.service;

import com.example.learnly.model.Student;
import com.example.learnly.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> find(long id) {
        return repository.findById(id);
    }

    public Student create(Student student) {
        student.setId(null);
        return repository.save(student);
    }

    public Optional<Student> replace(long id, Student student) {
        if (repository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        student.setId(id);
        return Optional.of(repository.save(student));
    }

    public boolean delete(long id) {
        return repository.deleteById(id);
    }
}
