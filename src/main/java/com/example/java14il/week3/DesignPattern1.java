package com.example.java14il.week3;


import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


/**
 * SOLID
 *      Single Responsibility
 *      Open Close
 *      Liskov Substitution
 *      Interface Segregation
 *      Dependency Inversion
 */

/**
 *  Singleton
 */
class SingletonLazyLoading {
    private static SingletonLazyLoading obj;
    private SingletonLazyLoading() {}
    public static SingletonLazyLoading getObj() {
        if(obj == null) {
            obj = new SingletonLazyLoading();
        }
        return obj;
    }
}

class SingletonDoubleCheckLazyLoading {
    private volatile static SingletonDoubleCheckLazyLoading obj;
    private SingletonDoubleCheckLazyLoading() {}
    public static SingletonDoubleCheckLazyLoading getObj() {
        if(obj == null) {
            synchronized (SingletonDoubleCheckLazyLoading.class) {
                if(obj == null) {
                    obj = new SingletonDoubleCheckLazyLoading();
                }
            }
        }
        return obj;
    }
}

class SingletonEagerLoading {
    private static final SingletonEagerLoading obj = new SingletonEagerLoading();
    private SingletonEagerLoading() {}
    public static SingletonEagerLoading getObj() {
        return obj;
    }
}

enum SingletonEnum {
    A, B;
}

/**
 * Factory
 *      interface B {}
 *      class BImpl1 implements B {}
 *      class BImpl2 implements B {}
 *      class BFactory {
 *          public static B getBImpl() {
 *              return new BImpl1();
 *          }
 *      }
 *      class StudentService {
 *          B b = BFactory.getBImpl(); 1000 lines
 *      }
 */

/**
 * Builder
 *  new StudentBuilderExample("", "", 0, 0.0, null, null.,,,, 20 attributes)
 */
class StudentBuilderExample {
    private String fn;
    private String ln;
    private int age;
    private double gpa;
    //..20 attributes


    public StudentBuilderExample() {
    }

    public StudentBuilderExample(String fn, String ln, int age, double gpa) {
        this.fn = fn;
        this.ln = ln;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFn() {
        return fn;
    }

    public StudentBuilderExample setFn(String fn) {
        this.fn = fn;
        return this;
    }

    public String getLn() {
        return ln;
    }

    public StudentBuilderExample setLn(String ln) {
        this.ln = ln;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentBuilderExample setAge(int age) {
        this.age = age;
        return this;
    }

    public double getGpa() {
        return gpa;
    }

    public StudentBuilderExample setGpa(double gpa) {
        this.gpa = gpa;
        return this;
    }

    public static void main(String[] args) {
        StudentBuilderExample s1 = new StudentBuilderExample()
                                            .setAge(9)
                                            .setGpa(0)
                                            .setLn("");
        StudentBuilderExample s2 = new XXXBuilder()
                                            .setFn("")
                                            .build();
    }
}
class XXXBuilder {
    private String fn;
    private String ln;
    private int age;
    private double gpa;

    public XXXBuilder() {
    }

    public String getFn() {
        return fn;
    }

    public XXXBuilder setFn(String fn) {
        this.fn = fn;
        return this;
    }

    public StudentBuilderExample build() {
        return new StudentBuilderExample(this.fn, this.ln, this.age, this.gpa);
    }
}
/**
 *  prototype
 *  s1("T", "K")
 *  s1("T", "K")
 */

/**
 *  Strategy
 */
@FunctionalInterface
interface CalculatorStrategy {
    int calculate(int v1, int v2);
}

class StrategyTest {
    public static int calculate(CalculatorStrategy strategy, int v1, int v2) {
        return strategy.calculate(v1, v2);
    }

    public static void main(String[] args) {
        CalculatorStrategy sumStrategy = (v1, v2) -> v1 + v2;
        System.out.println(calculate(sumStrategy, 5, 10));
    }
}
/**
 *  Bridge
 */
/**
 *  Observer
 */
class TopicWeek3 {
    private List<SubscriberWeek3> subscriberList = new ArrayList<>();
    public void subscribe(SubscriberWeek3 subscriber) {
        subscriberList.add(subscriber);
    }
    public void publish(String msg) {
        for(SubscriberWeek3 subscriber: subscriberList) {
            subscriber.receive(msg);
        }
    }
}
class SubscriberWeek3 {
    public void receive(String msg) {
        System.out.println(msg);
    }
}
/**
 *  Facade
 *                  |
 *              facade(gateway)
 *            /     \       \
 *         class1  class2  class3
 */

/**
 *  Composition
 *
 *  class Node {
 *      Node
 *  }
 *  class Employee {
 *      List<Employee>
 *  }
 */


/**
 *  1. create a binary tree
 *  2. print tree level by level
 *             0
 *          1    2
 *       3   4  5   6
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

class TreeTest {

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

class TreeTest2 {
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.print("\n");
        }
    }
}


class BTTranversal {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        void bfs (Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new ArrayDeque<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    System.out.println(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
        }
}

/**
 *  List of employees(id, name, age)
 *  1. write down all questions
 *     write a function which takes list of employees as input
 *     remove duplicate
 *  2. create a function
 *     use stream api, get employees whose age larger than 40
 *  3. create a function
 *     use one stream api to split list into 2 groups based on age
 *     List<List<Employee>> ,  [[employees' age < 40],  [employees' age >= 40]]
 *  4. create a class + function
 *     input 3 list of Integer, use multi-threading to sum all values from 3 list and return int result
 *     use CompletableFuture
 *  5. create a class + function
 *     create two threads and print even + odd number
 *     1   :  Thread1
 *     2   :  Thread2
 *     3   :  Thread1
 *     4   :  Thread2
 *     ....
 *
 *  deadline: tomorrow morning 10:00 am cdt
 *  upload to github
 */


class VolatileExample {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(flag) {}
            System.out.println("this is t1 after while loop");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            System.out.println("t2 change flag to: " + flag);
        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();

//        int v1 = 130;
//        int v2 = 130;
        Integer v3 = 128;
        Integer v4 = 128;
//        System.out.println(v1 == v2);
//        System.out.println(v1 == v3);
        System.out.println(v3.equals(v4));
    }
}

/**
 *
 *  Stream api
 *      stateful operation  (sorted, distinct)
 *      stateless operation (map, filter..)
 *
 *  S
 */
class HW1 {
    public static List<HW1Employee> removeDup(List<HW1Employee> emps) {
//        if(emps == null) {
//            throw new IllegalArgumentException()
//        }
//        Optional.ofNullable(emps).orElse(new ArrayList<>())
//                .stream()
//                .distinct()
//                .collect(Collectors.toList());
//        new ArrayList<>(new HashSet<>(emps));
        Iterator<HW1Employee> itr = emps.iterator();
        while(itr.hasNext()) {
            HW1Employee emp = itr.next();
            //..
        }
        for(HW1Employee emp: emps) {
            emps.add(null);
        }
        return null;
    }
}


class HW1Employee {
    private int id;
    private String name;
    private int age;

    public HW1Employee() {
    }

    public HW1Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HW1Employee that = (HW1Employee) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

class HW1CompletableFuture {
    private static ExecutorService pool = Executors.newCachedThreadPool();
    public static int sum1(List<List<Integer>> input) throws ExecutionException, InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();
        for(List<Integer> l: input) {
            Future<Integer> f = pool.submit(() -> l.stream().reduce(0, (x, y) -> x + y));
            futures.add(f);
        }
        int result = 0;
        for(Future<Integer> f: futures) {
            result += f.get();
        }
        return result;
    }

    public static int sum2(List<List<Integer>> input) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for(List<Integer> l: input) {
            CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(
                    () -> l.stream().reduce(0, (x, y) -> x + y),
                    pool
            );
            futures.add(cf);
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(Void -> {
                    int result = 0;
                    for(CompletableFuture<Integer> f: futures) {
                        result += f.join();
                    }
                    return result;
                }).join();
    }
}







