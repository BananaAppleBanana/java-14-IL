package com.example.java14il.week3;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {
}

/**
 * Adaptor
 */
interface Week3Apple {
    void func1();
}
interface Week3Banana {}
class Week3Child {
    public void eat(Week3Apple apple) {

    }
}
class AppleAdaptor implements Week3Apple {
    private final Week3Banana banana;

    public AppleAdaptor(Week3Banana banana) {
        this.banana = banana;
    }

    @Override
    public void func1() {
    }
}
/**
 * static proxy / decorator / wrapper
 */
interface Week3EmployeeService {
    //100 methods
    void print();
    int get();
    void set();
}
class Week3EmployeeServiceImpl implements Week3EmployeeService {
    @Override
    public void print() {
        System.out.println("this is my impl");
    }

    @Override
    public int get() {
        return 5;
    }

    @Override
    public void set() {
        System.out.println("set");
    }
}
//class Week3EmployeeServiceProxy implements Week3EmployeeService {
//    private final Week3EmployeeService employeeService;
//
//    public Week3EmployeeServiceProxy(Week3EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @Override
//    public void print() {
//        System.out.println("before");
//        employeeService.print();
//        System.out.println("after");
//    }
//}

/**
 * Dynamic proxy
 */
class DynamicProxyTest {
    public static void main(String[] args) {
        Week3EmployeeService proxyInstance = (Week3EmployeeService) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{Week3EmployeeService.class},
                new MyInvocationHandlerImpl(new Week3EmployeeServiceImpl())
        );
//        proxyInstance.print();
        System.out.println(proxyInstance.get());
//        proxyInstance.set();
    }
}
class MyInvocationHandlerImpl implements InvocationHandler {
    private final Week3EmployeeService employeeService;

    public MyInvocationHandlerImpl(Week3EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object obj = method.invoke(employeeService, args);
        System.out.println("after");
        return obj;
    }
}
/**
 *  rq625230882@gmail.com
 *  Homework:
 *      1. ignore Junit test => main method to test
 *      2. thread safe
 *      3. deadline : tomorrow morning 10am cdt
 */