package com.example.java14il.week5;


/**
 *  Monolithic -> University Management System
 *
 *                           LoadBalancer(node4)
 *
 *            /                |                          \
 *
 *  node1(UMS 1.2)        node2(UMS 1.2)             node3(UMS 1.2)
 *
 *      1. scalability
 *          horizontal scaling
 *          vertical scaling
 *      2. deployment
 *      3. fail tolerance
 *
 *  Microservice : University Management System
 *                  security service, student service, teacher service, registration service
 *
 *
 *                             / request1
 *                      Api Gateway(node9, node10)  -- security service
 *                          / request2(header : co-relation id)
 *                       registration service(node1, node2, node3)
 *              /request3(header : co-relation id)           | request4(header : co-relation id)
 *          stu service                                   teacher service
 *           (node4, node5)                                (node6, node7, node8)
 *
 *
 *     1. Api gateway : Zuul(gateway server) + Ribbon(library)
 *          rate limiter
 *          co-relation id / global unique id
 *              1. UUID
 *              2. snowflake
 *              3. database primary key
 *     2. Discovery service / Service registration center(ip7) : Eureka
 *          registration     -> http request: ip+port   ->     stu service
 *
 *          a. start service A
 *          b. service A -> send request to discovery service(with ip+port)
 *          c: save info in discovery service
 *    service name key: value
 *       registration: ip1, ip2, ip3
 *       student     : ip4, ip5
 *          d: registration     -> http request: http://service-name/..   ->     stu service
 *               |=====> use service-name(student) to fetch ip address from discovery service
 *               |===> get ip 4 and ip5
 *               |=> use load balancing rule / algorithm to decide ip4 vs ip5
 *      3. centralized security service
 *      4. configuration service
 *      5. A -> message queue -> B  => BASE => eventually consistency
 *          fail tolerance
 *      6. Database cluster +  transaction  + cache
 *      7. docker container
 *      8. centralize log (Splunk) => search keyword
 *      9. circuit breaker : Spring Cloud Hystrix
 *          A -> request -> B -> request -> C
 *            if 3 of 5 requests failed
 *                 close connection => return default data
 *                 background thread => C => check health status => re-open
 *      10. CAP
 *          consistency
 *          availability
 *          partition tolerance
 *
 * Disadvantages of Microservice
 *      1. cost
 *      2. fail tolerance
 *      3. global transaction
 *      4. consistency
 *      5. business boundary
 *      6. slow down performance
 *      ..
 *
 * Tomorrow
 *      1. check project => weather
 *      2. Spring cloud framework
 *      3. common package
 *      4. multi-modules maven project
 *
 */