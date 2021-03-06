package com.example.java14il.week4.rest.controller;

import com.example.java14il.week4.rest.domain.CommonResponse;
import com.example.java14il.week4.rest.domain.ErrorResponse;
import com.example.java14il.week4.rest.domain.Student;
import com.example.java14il.week4.rest.exception.ResourceNotFoundException;
import com.example.java14il.week4.rest.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<CommonResponse> getAllStudents(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<CommonResponse> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/students") //not idempotent
    public ResponseEntity<CommonResponse> createStudent(@RequestBody Student student) {
         //id
        return null;
    }

    //update student id : 500 , set name from tom to jerry
    @PutMapping("/students/{id}") // idempotent
    public ResponseEntity<CommonResponse> updateStudent(@PathVariable String id, @RequestBody Student student) {
        //id
        return null;
    }

    @DeleteMapping("/students/{id}") // idempotent
    public ResponseEntity<CommonResponse> delete(@PathVariable String id) {
        //id
        return null;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundHandler() {
        return new ResponseEntity<>(new ErrorResponse("this is the message", new Date()), HttpStatus.NOT_FOUND);
    }
}
