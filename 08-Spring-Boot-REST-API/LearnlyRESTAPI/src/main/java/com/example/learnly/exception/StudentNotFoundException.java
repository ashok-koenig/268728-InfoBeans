package com.example.learnly.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(long id){
        super("No student with id "+ id);
    }
}
