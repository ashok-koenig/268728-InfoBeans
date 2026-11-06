package com.example.catalogue.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long id){
        super("Course "+ id + " not found");
    }
}
