package com.example.java14il.week4.rest.repository.impl;

import com.example.java14il.week4.rest.domain.Student;
import com.example.java14il.week4.rest.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<String, Student> studentMap = new HashMap<>();

    @PostConstruct
    private void init() {
        Student s1 = new Student("1", "Tom", true);
        Student s2 = new Student("2", "Jerry", true);
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }
}
