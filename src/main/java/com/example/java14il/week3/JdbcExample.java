package com.example.java14il.week3;

import java.sql.*;


/**
 * homework : deadline => next Monday 10am CDT
 * 1. download database
 * 2. create teacher(salary) m - m student
 * 3. use jdbc to query database
 *    select all teacher info (include student info)
 *    count student of each teacher
 *    get teacher which has 2nd highest salary(rank, dense_rank)
 *
 * Hibernate + JPA + Maven(pom.xml)
 * 1. ORM
 * 2. first level cache / second level cache
 * 3. connection pool
 * 4. Jpql / Hql
 * 5. data source
 * 6. lazying vs eager loading
 * 7. annotations
 *
 * Spring IOC + AOP
 * Spring boot
 * Network basic + Http
 * Restful api
 * security(Https, Jwt..)
 */

public class JdbcExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 2: Register JDBC driver -> DriverManager
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String username = "";
            String password = "'xxx OR TRUE; DROP table'";
            String sql1 = "SELECT .... first, last, age FROM Employees WHERE username = "
                    + username + " AND password = " + password;
            String sql2 = "SELECT .... first, last, age FROM Employees WHERE age..";
            String sql3 = "SELECT .... first, last, age FROM Employees WHERE age .. And first = ";
            String sql4 = "SELECT .... first, last, age FROM Employees WHERE age or first..";
            stmt = conn.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            conn.commit();
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}



class A {
    public void update1() {
        int val = 1;
        val++;
    }

    int v2 = 1;
    public void update2() {
        v2++;
    }

    public static void main(String[] args) {
        A a = new A();
//        Thread t1 = new Thread(() -> a.update());
//        Thread t2 = new Thread(() -> a.update());
//        t1.start();
//        t2.start();
    }
}

/**
 *   [2, 3, 4, 5, 6, 3]
 *   min Heap   N = 3
 *   minHeap [2, 3, 4]
 *   5  => offer(5) => [2, 3, 4, 5] => poll() => [3, 4, 5]
 *   6  => offer(6) => [3, 4, 5, 6] => poll() => [4, 5, 6]
 *   3  => offer(3) => [3, 4, 5, 6] => poll() => [4, 5, 6]
 *
 *
 *   concurrent hashmap iteration / iterator
 *    put(1, 5), put(2, 6)                          put(2, 8)    put(1, 2)
 *   ------------------------------------------------------------------------------> time
 *                            iterator, get(1)                        iterator get(2)
 *
 *   [5, 8]
 *
 *   Is concurrent hashmap locking / synchronized get()?   no
 *   How does concurrent hashmap keep get() thread safe?   volatile
 *
 *
 *  ConcurrentHashMap map = ..
 *  public void add(int key, int value) { //key = 1, value = 1
 *      int prevValue = map.getOrDefault(key, 0);  // prevValue = 5
 *      //... [1, 10]
 *      map.put(key, prevValue + value); //[1, 6] => [1, 16]
 *  }
 *
 *  map.compute(key, (k
 *
 */
class OuterClass {
    public class InnerClass {

    }
}
class TestInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
//        new OuterClass.InnerClass()
    }
}
/**
 * heap<Integer> [1, 2] min heap
 * Map<Integer, Integer>  [1, 2], [2, 3]
 * map.put(1, 5)
 * heap.poll() => [1, 5] / [2, 3]
 * will heap reorder data ?
 *
 */