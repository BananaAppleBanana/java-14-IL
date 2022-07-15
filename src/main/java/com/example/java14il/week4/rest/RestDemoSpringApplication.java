package com.example.java14il.week4.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestDemoSpringApplication.class, args);
    }
}

/**
 *
 *  Web service vs Restful Api vs Http
 *  Restful api
 *      1. architecture
 *      2. Http: method, status code, header..
 *      3. noun, endpoint / url / uri : /students
 *      4. stateless
 *  student
 *      1. retrieve all students information
 *          endpoint: /students?age=50&name=...
 *          http method: get
 *          http status: 200, 400, 500
 *          response:
 *              {
 *                  data: [
 *                      {
 *                          id: "1",
 *                          name: "Tom"
 *                      },
 *                      {
 *                          id: "2",
 *                          name: "Tom"
 *                      }
 *                  ]
 *              }
 *
 *      2. get student info by id
 *          endpoint: /students/{id}
 *          http method: get
 *          http status: 200, 400, 500
 *          response:
 *                      {
 *                          id: "1",
 *                          name: "Tom"
 *                      }
 *      3. create new student
 *          endpoint: /students
 *          http method: post
 *          http status: 201, 400, 500
 *          request body:
 *              {
 *                  name: "Tom"
 *              }
 *          response:
 *              {
 *                  id: "2"
 *              }
 *
 *      4. update student
 *          endpoint: /students/{id}
 *          http method: post
 *          http status: 200, 400, 500
 *          request body:
 *              {
 *                  name: "Tom"
 *              }
 *
 *      5. remove a student from system
 *          ...
 *
 *
 */
