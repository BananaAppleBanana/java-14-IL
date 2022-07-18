package com.example.java14il.week4.rest.repository.impl;

import com.example.java14il.week4.rest.domain.Student;
import com.example.java14il.week4.rest.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<String, Student> studentMap = new ConcurrentHashMap<>();

    private final AtomicLong id = new AtomicLong(0);

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


    public String createStudent(Student student) {
        String curId = String.valueOf(id.getAndAdd(1));
        //..
        student.setId(curId);
        studentMap.put(curId, student);
        return curId;
    }

//    private synchronized int nextId() {
//        return ++id;
//    }
}
/**
 *  1. Volatile + CAS => Atomic Library
 *  2. synchronized + ReentrantLock + CountDownLatch + Semaphore + CyclicBarrier
 *  3. concurrent API
 *  4. immutable class
 *  5. local variables / objects
 *  ..
 */
