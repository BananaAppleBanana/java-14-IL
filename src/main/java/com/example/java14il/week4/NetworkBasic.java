package com.example.java14il.week4;


/**
 *
 *  Server <-> Client(user - interface)
 *
 *  ip => public + private
 *        0.0.0.0
 *        255.255.255.255
 *  port
 *  connection => source ip + source port,  destination ip + destination + port
 *  what happens if you click url
 *      1. browser => open a random port
 *      2. www.xx.com  => look up ip in DNS  => get public ip
 *      3. mac address <=exchange=> private ip
 *      4. get a public ip NAT , open a port for you
 *          user 1:  private ip1 + port 8080  =>  public ip1 + port 9000
 *          user 2:  private ip2 + port 8080  =>  public ip1 + port 9001
 *      5. build connection source ip + source port,  destination ip + destination + port
 *      6. 3 ways handshake tcp
 *                  connection
 *      seq 1005    client   -> flag = 1  ->  server
 *                  client   <- ack = 1006 -> server
 *          1006   client   ->
 *
 *      len = 100    client  -> data ->      server
 *                  client   <- ack = 1106  server
 *      7. socket
 *              get a thread from thread pool
 *              assign this connection to that thread
 *                  http: method : get / post / put / delete
 *                  http: header..
 *                  http: url  : /student
 *      old impl
 *      8. servlet =>
 *              /student => StudentServlet class (..)
 *              /employee => EmployeeServlet class(doGet()..)
 *      new impl
 *      8. Spring MVC => dispatcher servlet(/*) => handler mapping => controller class => @GetMapping("/student")
 *                              ||
 *                              \/
 *              @ResponseBody HttpMessageConverter /  view resolver (.jsp / .html)
 *                              |
 *                       Jackson converts pojo to json
 *
 *
 *
 *
 *  A   application layer   =>   http                       [http info][data]
 *  P   presentation layer  =>   ssl
 *  S   session layer       =>
 *  T   transport layer     =>   tcp / udp (port)           [tcp header][http info][data]
 *  N   network layer       =>   ip                         [ip header][tcp header][http info][data]
 *  D   data link layer     =>   ethernet , mac address
 *  P   physical layer      =>   cable
 *
 *
 *
 *  Http
 *      1. url /xxx
 *      2. method
 *              get => retrieve resources
 *              post => create new resource
 *              put => update resource
 *              patch => update partial resource
 *              delete => delete resource
 *      3. status
 *              200 success , 201 created , 204 no-content
 *              300 redirection
 *              400 client side error , 401 , 403
 *              500 server side error
 *      4. header
 *              Content-Type :
 *              Accept :
 *              Cookie
 *      5. request body + response body
 *
 *  cookie vs session
 *      browser -> send request -> server (check session id)
 *                                  create a session + session id
 *             <- send response (session id)
 *
 *  loadbalancer
 *                              |
 *
 *                         loadbalancer
 *                 /            |              \
 *               /              |               \
 *       Tomcat1            Tomcat2             Tomcat3
 *
 *
 *  Tomorrow
 *      Restful api design
 *      create spring boot rest api
 */
