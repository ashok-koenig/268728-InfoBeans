package com.example.learnly.model;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String passwordHash;           // internal: must never be sent to a client

    public Student() {
    }

    public Student(Long id, String name, String email, String city, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
