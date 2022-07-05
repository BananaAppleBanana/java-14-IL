package com.example.java14il.week3;


/**
 *
 *  Java
 *  OOP
 *      polymorphism
 *      encapsulation
 *      abstraction
 *          Question: when to use abstract class
 *      inheritance
 *  collection
 *      hashmap
 *          Question:
 *              why do we need to override equals + hashcode
 *      treemap
 *
 *  multi-threading
 *      synchronized(object/instance)
 *      BlockingQueueT
 *      ConcurrentHashMap
 *      Atomic library  : A-B-A problem
 *  DB
 *  query
 *     rank vs dense_rank
 *     count(*) vs count(column)
 *     inner join vs outer join
 *
 * select t.*
 * from (select d.*, dense_rank() over (partition by e.department_id order by salary desc) as rank
 *      from dept d join emp e on d.department_id = e.department_id) t
 * where t.rank = 2;
 *
 * select d.*, count(e.first_name)
 * from dept d left join emp e on d.department_id = e.department_id
 * group by d.department_id
 *
 *  transaction
 *      update / insert / delete / select...for update
 *      ACID
 *      dirty read / non-repeatable read / phantom read / lost update
 *  index
 *
 *             [15,   25]
 *            /     \       \
 *      [2, 10]- [15, 20] - [25, 30]
 *
 *   execution plan
 *      full table scan
 *      index unique scan
 *      index range scan
 *      index full scan
 *      index fast full scan
 *  tuning
 *      hint
 *  optimistic lock
 *      user1 ->read value = 1, version = 1 ->  update value 1 to 3, version + 1 where version = current version
 *      user2 ->read value = 1, version = 1 -> update 1 to 5 where version = 2
 *              read value = 3,  version = 2 -> ...
 *  table
 *      dept(id) 1 - m emp(id, dept_id)
 *      dept m - m emp => dept,  dept_emp,  emp
 *
 *  Tomorrow:
 *      SOLID
 *      Java 8 + CompletableFuture
 *      design patterns
 *          singleton
 *          factory
 *          builder
 *          template
 *          prototype
 *          bridge
 *          strategy
 *          composition
 *          facade
 *          observer
 *          adapter
 *          decorator (static proxy)
 *          dynamic proxy
 *     10:00 am CDT
 */
