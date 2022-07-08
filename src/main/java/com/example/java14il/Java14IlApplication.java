package com.example.java14il;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Java14IlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java14IlApplication.class, args);
    }

}

class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.parallelStream()
                .map(x -> x)
                .distinct()
                .filter(x -> x > 5)
                .forEach(x -> System.out.println(x));
    }
}
