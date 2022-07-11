package com.example.java14il.week4;

/**
 *  JDBC vs ORM
 *      1. HQL / JPQL :  hibernate converts hql to diff native sql query
 *      2. sql injection
 *          public xx execute(String un, String pw) {
 *              String query = "select * from table where username = " + un + " and password = " + pw;
 *              ..
 *         }
 *
 *      user => un : "xxxxasdfadsf"
 *              pw : "xafasdfasdf \" or true"
 *      select * from table where username = "xxxxasdfadsf" and password = "xafasdfasdf or true"
 *      select * from table where username = "xxxxasdfadsf" and password = "'xafasdfasdf \' or true"
 *
 *         how should we store password in database
 *         String vs char[]
 *         what is heap dump(file)   => out of memory / memory leak
 *
 *        out of memory =>
 *              young + old generation
 *              perm generation => meta space (native heap)
 *
 *         CMS
 *              1. initial mark(STW)
 *              2. concurrent mark
 *              3. final mark(STW)
 *              4. concurrent sweep
 *
 *         G1
 *              [Y][][][][][]
 *              [][O][][][Y][]
 *              [][][][O][][]
 *              [][][][][][]
 *              5 young blocks + 1 old blocks
 *        Reference Type
 *        String name = "ll"
 *        SoftReference
 *        WeakReference
 *        PhantomReference + ReferencedQueue
 *     3. criteria query(builder pattern)
 *          select
 *          from
 *          where name =
 *          where name = or age =
 *          where age = and id > ..
 *     4. connection pool
 *     5. objects mapping
 *     6. caches
 *
 *
 *  tomorrow :
 *         lombok
 *         how to connect to database
 *         how to use hibernate
 *         diff lazy loading and eager loading
 *         what is jpa / diff between hibernate and jpa
 *         what is spring data jpa
 *         what is criteria query
 *  homework:
 *      deadline Wed's morning 10am cdt
 *      1. create database tables
 *          book m - m author
 *      2. create entity relations from hibernate
 *          @OneToMany + @ManyToOne
 *          ****DO NOT USE @ManyToMany
 *      3. CRUD on book table
 *      4. use join to select data from both tables
 *      5. insert elements into junction table
 *
 *   option1: use spring boot + restful api
 *   option2: main method to execute queries
 */
