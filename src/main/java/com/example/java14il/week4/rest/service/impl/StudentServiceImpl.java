package com.example.java14il.week4.rest.service.impl;

import com.example.java14il.week4.rest.domain.CommonResponse;
import com.example.java14il.week4.rest.domain.Student;
import com.example.java14il.week4.rest.domain.dto.StudentResponseDTO;
import com.example.java14il.week4.rest.exception.ResourceNotFoundException;
import com.example.java14il.week4.rest.repository.StudentRepository;
import com.example.java14il.week4.rest.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CommonResponse getAllStudents() {
        CommonResponse response = new CommonResponse();
        List<StudentResponseDTO> studentResponseDTOS = studentRepository.getAllStudents().stream().map(s -> new StudentResponseDTO(s)).collect(Collectors.toList());
        response.setData(studentResponseDTOS);
        return response;
    }

    @Override
    public CommonResponse getStudentById(String id) {

        CommonResponse response = new CommonResponse();
        Student stu = studentRepository.getStudentById(id);
        if(stu == null) {
            log.error("{} id cannot be found in system", id);
            throw new ResourceNotFoundException("........");
        }
        response.setData(new StudentResponseDTO(stu));
        return response;
    }
}
