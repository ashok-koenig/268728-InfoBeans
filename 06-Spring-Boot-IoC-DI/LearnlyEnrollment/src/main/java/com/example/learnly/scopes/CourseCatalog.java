package com.example.learnly.scopes;

import org.springframework.stereotype.Component;

@Component
public class CourseCatalog {
    public CourseCatalog() {
        System.out.println("CourseCatalog created");
    }
}
