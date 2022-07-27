package com.example.java14il;

import com.example.java14il.week4.rest.domain.Student;
import com.example.java14il.week4.rest.repository.StudentRepository;
import com.example.java14il.week4.rest.service.StudentService;
import com.example.java14il.week4.rest.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;


class Java14IlApplicationTests {

    private static StudentService studentService;

    @BeforeEach
    public static void init() {
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        Mockito.when(studentRepository.getAllStudents()).thenReturn(Arrays.asList(new Student("10000", "Tom", true)));
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void contextLoads() {
        System.out.println(studentService.getAllStudents());
        //assertTrue / assertThat..
    }

}
