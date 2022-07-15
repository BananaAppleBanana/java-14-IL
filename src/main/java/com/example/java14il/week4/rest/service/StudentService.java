package com.example.java14il.week4.rest.service;

import com.example.java14il.week4.rest.domain.CommonResponse;
import com.example.java14il.week4.rest.domain.Student;

import java.util.List;

public interface StudentService {
    CommonResponse getAllStudents();
    CommonResponse getStudentById(String id);
}
