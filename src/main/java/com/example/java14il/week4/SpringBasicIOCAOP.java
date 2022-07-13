package com.example.java14il.week4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 *
 *
 * class Test {
 *     public static void main(String[] args) {
 *         B b = new B();
 *         A a = new A(b);
 *     }
 * }
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target(ElementType.FIELD)
 * @interface Inject { }
 *
 * @Component
 * class A {
 *     @Inject
 *     private B b2;
 *
 *     @Inject
 *     private B b1;
 *
 *     public A(B b) {
 *         this.b = b;
 *     }
 *
 *     public void setB(B b) {
 *         this.b = b;
 *     }
 * }
 * @Component
 * class B {
 *
 * }
 * class C {
 *
 * }
 *     Spring IOC
 *          dependency injection
 *          1. ApplicationContext(IOC container)
 *          2. BeanDefinition
 *
 *          flow:
 *              1. scan class information / class objects
 *              2. read @Component
 *              3. load instance / bean information into IOC container
 *              4. @Autowired to inject instance
 *          injection type:
 *              1. ByType injection
 *              2. ByName injection : @Qualifier
 *          injection strategy:
 *              1. constructor
 *              2. setter
 *              3. field (do not use it)
 *          bean scope
 *              1. singleton (default)
 *              2. prototype
 *              3. request
 *              4. session
 *              5. global session
 *          mark beans with diff annotations:
 *              on top of the class
 *              1. @Component
 *              2. @Controller : SpringMVC + restful
 *              3. @Service : business layer
 *              4. @Repository : DAO layer
 *
 *              on top of the method
 *              5. @Bean
 *
 */
@SpringBootApplication
class SpringBasicTest {

    private static Week4SpringStudent student1;
    private static Week4SpringStudent student2;

    @Autowired
    public SpringBasicTest(@Qualifier("week4SpringStudentImpl2")Week4SpringStudent student1, @Qualifier("week4SpringStudentImpl2") Week4SpringStudent student2) {
        SpringBasicTest.student1 = student1;
        SpringBasicTest.student2= student2;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicTest.class, args);
        System.out.println(student1 == student2);
    }

}

@Component
interface Week4SpringStudent {
    void print();
}

@Component
class Week4SpringStudentImpl1 implements Week4SpringStudent{
    @Override
    public void print() {
        System.out.println("this is student impl 1");
    }
}

@Component
@Scope("prototype")
class Week4SpringStudentImpl2 implements Week4SpringStudent{
    @Override
    public void print() {
        System.out.println("this is student impl 2");
    }
}

/**
 *
 *  class Aspect {
 *
 *      //provide point cutting => location of those aop methods
 *
 *      @After
 *      //point cutting : location
 *      public void printAfter() {
 *          System.out.println("this is after");
 *      }
 *
 *      @Before
 *      //point cutting : location
 *      public void printBefore() {
 *          System.out.println("this is before");
 *      }
 *  }
 */


/**
 *  Tomorrow
 *      Server
 *      Client
 */














