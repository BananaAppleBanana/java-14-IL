package com.example.java14il.week5;


/**
 *  encode + decode vs encrypt + decrypt
 *   string -> encode -> standard characters -> router  -> ...  ->  standard characters -> decode -> data
 *
 *  status 401 => un-authenticated, token expired
 *  status 403 => un-authorized
 *  -> resource service
 *  1. authentication -> server
 *  2. jwt <- server generate
 *  3. request(jwt) -> resource service
 *
 *  1. authentication
 *      username - password
 *      email
 *      phone
 *      identity
 *
 *  2. authorization => role (admin..)
 *      JWT
 *      header.payload.signature
 *      encode(header.payload.encrypt(header.payload))
 *
 *  3.  Https = Http + SSL / TLS
 *      symmetric key => encrypt + decrypt
 *      asymmetric key => private key + public key
 *      CA
 *
 *      client    ->   hi       ->  server(private key)
 *           <-  certificate / public key  <-
 *           ->   public key[generate random data] ->
 *           <-   hash(random data)  <-
 *           ->   symmetric key[data] ->
 *           <-   symmetric key[data] <-
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  Filter
 *          filter1(verify jwt token) -> filter2(check if request contains username + password).. -> filter3(check if security context is null) .. ->  -> controller
 *                      |
 *                      yes
 *                      |
 *                  SecurityContext
 *                     |
 *                  ThreadLocal
 *
 *                                                                                                                           clean up thread local <- controller
 *
 *  Tomorrow : microservice
 *  Homework:
 *      1. create spring boot project
 *      2. create 2 endpoints =>
 *          1. get all employees
 *          2. get employees whose age larger than xx value
 *          (you should use same path,  use request param,  => param in different method)
 *      3.  configure resttemplate in configuration class => use @Bean to load resttemplate instance
 *          send request by using "RestTemplate" => to 3rd party api
 *          getForObject("url", class type)
 *          create Employee pojo class to map response from 3rd party api
 *          class A {
 *              B data;
 *          }
 *          class B {
 *
 *          }
 *          {
 *              data {
 *
 *              },
 *          }
 *      4. in 25 min
 *
 *
 */