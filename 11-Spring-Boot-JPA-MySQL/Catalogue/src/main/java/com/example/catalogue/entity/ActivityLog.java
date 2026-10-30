package com.example.catalogue.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_log")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public ActivityLog() {
    }

    public ActivityLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
