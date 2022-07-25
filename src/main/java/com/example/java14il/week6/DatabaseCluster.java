package com.example.java14il.week6;

/**
 * @LoadBalanced
 * @Bean
 * public RestTemplate getServiceRestTemplate() {
 *     return new RestTemplate();
 * }
 *
 * restTemplate.getForObject(http://employee-service/employees?age=xx,xx, Response.class)
 */


/**
 *  Leader - Follower
 *  Master - Slave
 *  Primary - Secondary
 *
 *  write -> leader
 *  read -> leader / follower
 *
 *
 *  Single Leader
 *                  |
 *               DB1(Leader)
 *          /                   \               \
 *      DB2(Follower1)       DB3(Follower2)      DB4(Follower3)
 *
 *
 *      user -> request -> db1 + at least 1 follower  / all followers
 *
 *
 *  Multi Leader
 *
 *              |
 *          DB1 Leader     ->     DB2 Leader    ->    DB3
 *        /     \
 *     DB4 follower DB5
 *
 *  LeaderLess
 *       Cassandra
 *
 *    *        *        *        *        *        *        *        *        *        *
 *  Sharding / Partition
 *      Single Leader
 *           1. odd / even id
 *              1 % 2 => instance 1
 *              2 % 2 => instance 0
 *              3 % 2 => instance 1
 *              4 % 2 => instance 0
 *                 leader1 DB1 (odd id)            leader2 DB2 (even id)
 *                  ||
 *                  \/
 *          2. id % instance number = location / index
 *             1 % 3 => instance 1
 *             2 % 3 => instance 2
 *             3 % 3 => instance 0
 *             4 % 3 => instance 1
 *             instance1 (id : 1, 4, 7, 10, 13...)
 *          3. hash(id) % instance number
 *          4. instance1(id: 1 ~ 10k)
 *             instance2(id: 10k+1 ~ 20k)
 *
 *
 *                   api gateway     ->    config server(metadata)
 *
 *                /         \           \           \
 *          Leader1         Leader2     Leader3     Leader4
 *          Follower1
 *          Follower2
 *       id 1 ~ 10k
 *
 *      LeaderLess (LSM + Sequential IO)
 *          1. consistent hashing
 *
 *                     N1(0)
 *                          NX(5k)
 *        ..   N6             N2(10K)
 *
 *        ..  N5              N3(20K)
 *                   N4(30K)
 *
 *               calculate(hash, 70K) => index
 *         2. replica factor : 3 (data in 3 nodes)
 *         3. read consistency : 1 ~ replica factor
 *            write consistency : 1 ~ replica factor
 *
 *            replica => 3
 *            write => 2
 *            read => 2  => trigger read repair
 *            write + read > replica
 *
 *
 *                  -> mem table  -> Sorted String table(immutable file)
 *                  + commit log
 *
 *
 *                  SST1        SST2          SST3          SST4
 *
 *    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *    Tomorrow : 1:30pm CDT
 *          1. cache
 *          2. message queue
 *          3. global transaction
 *    Wed :
 *          1. testing
 *          2. Agile scrum
 *          3. daily work
 *          4. jenkins pipeline
 *   Thurs :
 *          1. AWS introduction
 *          2. interview questions
 *
 *
 */

