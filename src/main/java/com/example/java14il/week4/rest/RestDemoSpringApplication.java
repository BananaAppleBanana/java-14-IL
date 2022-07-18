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
 * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  1. make it thread safe
 *  2. provide update + create + delete rest endpoint
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  homework
 *      1. add rest apis to your hibernate / orm homework
 *      2. add exception handling
 *      3. add logger(debug + error messages)
 *      4. add Aspect + AOP => log service before + after (print in console)
 *      5. use @ControllerAdvice to handle global exception
 *      6. add Rest Controller Advice to centralize response after controller returns data
 *
 *
 *  Question:
 *      1. what is the default bean scope ?
 *      2. is our application thread safe ?
 *
 *         public void get() {
 *              int a = 5;
 *              a++;
 *              return a;
 *         }
 *
 *         Stack in JVM
 *         Thread1 -> Stack1 -> push method frame => int a1 = 5
 *         Thread2 -> Stack2 -> push method frame => int a2 = 5
 *
 *         Tomcat [thread pool] -> request1 -> Thread1  -> controller instance1 -> service instance1
 *                                 request2 -> Thread2  -> controller instance1 -> service instance1
 *
 *     3. what is good api / restful api
 *          1. good OOP + OOD design
 *             follow http protocol / restful api standard
 *          2. good error handling
 *          3. test cases
 *          4. log
 *          5. performance
 *          6. security
 *          7. documentation
 *          ...
 *
 *
 *  Tomorrow
 *      1. Authentication
 *      2. Authorization + JWT
 *      3. Https
 *      Spring Security
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
