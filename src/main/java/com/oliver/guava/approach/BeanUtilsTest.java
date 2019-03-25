package com.oliver.guava.approach;

import com.oliver.guava.approach.info.Student;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class BeanUtilsTest {
    public static void main(String[] args) {
        Student student = BeanUtils.instantiateClass(Student.class);
        student.setGrade("3年4班")
                .setName("徐大聪明")
                .setAge(10)
                .setId(1000);

        System.out.println(student.getClass().getName());
        System.out.println(student);
        System.out.println("------------------------------------");

        System.out.println(Student.class.isAssignableFrom(B.class));

        System.out.println(Serializable.class.isAssignableFrom(B.class));
        System.out.println(A.class.isAssignableFrom(B.class));

        A a = new A();
        B b = new B();

        System.out.println(a.getClass().isAssignableFrom(b.getClass()));
        System.out.println(A.class.isAssignableFrom(b.getClass()));
        System.out.println(A.class.equals(a.getClass()));

        System.out.println("************************************************************");



    }
}

class A {
}

class B extends A implements Serializable {
}
