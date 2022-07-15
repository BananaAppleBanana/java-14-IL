package com.example.java14il.week4.rest.domain.dto;


import com.example.java14il.week4.rest.domain.Student;

public class StudentResponseDTO {

    private String id;
    private String name;

    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
