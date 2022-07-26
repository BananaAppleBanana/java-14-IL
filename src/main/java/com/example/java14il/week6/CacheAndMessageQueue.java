package com.example.java14il.week6;

/**
 *  1. local cache : session / concurrent hashmap
 *  2. global cache cluster
 *      Redis
 *          hash slots
 *          leader1(0 ~ 5000)      leader2(5001 ~ 7000)
 *         /      \
 *    follower1,  2
 *
 *   *   *   *   *   *   *   *   *   *   *
 *   write through / read through
 *          server <-> cache <-> database
 *   cache aside
 *          server  <->   cache
 *            |
 *          database
 *
 *         1. read from cache
 *                  find data -> return data
 *                  cannot find -> search database -> save data into cache -> return data
 *         2. write cache
 *                  remove related data from cache
 *                  write to database
 *   *   *   *   *   *   *   *   *   *   *   *   *
 *
 *     producer(server)   ----   message queue(server)  -----  consumer(server)
 *
 *     why message
 *          1. Asynchronous communication
 *          2. More request
 *     message queue example
 *          1. Rabbit MQ / Active MQ => long time task
 *                      [c]
 *              -----  message queue -----  consumer1[b]
 *                                          consumer2[a]
 *                                          consumer3
 *          2. Kafka => million messages / sec
 *
 *                         broker1(partitions)
 *
 *
 *               broker2            broker3
 *
 *
 *         Topic1                                               Consumer Group1
 *              partition1                                      consumer1 (Topic1+partition1, Topic1+partition2)
 *              partition2                                      consumer2 (Topic1+partition3)
 *              partition3
 *                                                              Consumer Group2
 *                                                              consumer1 (Topic1+partition1, Topic1+partition2, Topic1+partition3)
 *
 *        Topic2
 *              partition1
 *              partition2
 *
 *          3. SQS + SNS (AWS) => aws platform
 *
 *              SNS : publisher + subscriber
 *
 *                      = SQS1
 *              SNS ->  = SQS2
 *                      = SQS3
 *
 *
 *              SQS : queue  (visibility timeout)
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *     Issues
 *      1. duplicate message
 *             unique message id
 *             idempotent + eventually consistency
 *             cache
 *              producer(server)   ----   message queue(server)  -----  consumer(server)
 *                                                                          |
 *                                                                          cache
 *
 *
 *
 *      2.   producer(server)   ----   message queue(server)  -----  consumer(server)
 *              |
 *            database
 *
 *         begin transaction
 *              message queue
 *              database
 *         commit transaction
 *
 *         eg.
 *            1. send message to message queue
 *              crash
 *            2. save data into database
 *
 *            1. save data into database
 *              crash
 *            2. send message to message queue
 *
 *        solution: CDC(change data capture) + outbox table
 *            1. begin tx
 *               save data into database
 *               save message into database (outbox table)
 *               commit tx
 *            2. send response to user
 *
 *            producer(server)   -> database ->  monitor service(change data capture service)  ->  message queue(server)  -----  consumer(server)
 *    3.  global transaction
 *          solutions
 *              1. 2pc commit / 3pc commit
 *
 *                       service
 *                          |
 *                      coordinator
 *                      /       \
 *                    DB1       DB2
 *              2. SAGA pattern
 *                     book flight                                     book hotel
 *                     service1         -  message queue  -           service2
 *                      |                                               |
 *                     DB1                                              DB2
 *
 *                             <-  message queue <- compensation message
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *    Tomorrow  10am cdt
 *      1. unit testing => Junit + mockito
 *      2. other testing
 *      3. agile scrum + daily work
 *      4. jenkins pipeline + deployment
 */