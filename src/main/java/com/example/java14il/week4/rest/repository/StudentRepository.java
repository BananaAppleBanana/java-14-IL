package com.example.java14il.week4.rest.repository;

import com.example.java14il.week4.rest.domain.Student;

import java.util.Collection;

public interface StudentRepository {
    Collection<Student> getAllStudents();
    Student getStudentById(String id);
}
