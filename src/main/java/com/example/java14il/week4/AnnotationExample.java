package com.example.java14il.week4;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 *  ResultSet => id, name
 *      1.  stu = new OrmStudent();
 *          stu.setId()
 *          stu.setName()
 *      2.  new OrmStudent().setId().setName()
 *      3.  factory
 *      4.  reflection
 */
class OrmReflection {
    public static void main(String[] args) throws Exception {
        String id = "1";
        String name = "T";
        OrmStudent ormStudent = new OrmStudent();
        System.out.println(ormStudent);
        Class<?> clazz = ormStudent.getClass();
        Field idField = clazz.getDeclaredField("id");
        Field nameField = clazz.getDeclaredField("myName");
        System.out.println(((MyColumn)nameField.getDeclaredAnnotations()[0]).name());
//        idField.setAccessible(true);
//        nameField.setAccessible(true);
//        idField.set(ormStudent, id);
//        nameField.set(ormStudent, name);
//        System.out.println(ormStudent);
    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyColumn {
    String name() default "";
}
//db table student(id, name)

class OrmStudent {
    private String id;

    private String myName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public String toString() {
        return "OrmStudent{" +
                "id='" + id + '\'' +
                ", name='" + myName + '\'' +
                '}';
    }
}