package com.oliver.guava.approach;

import com.oliver.guava.approach.info.Student;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/18
 * @Since
 */
public class ObjectsTest {
    public static void main(String[] args) {
        Student student = BeanUtils.instantiateClass(Student.class);
        student.setId(666)
                .setAge(100)
                .setGender("male")
                .setName("尼古拉斯·徐迪")
                .setGrade("3年1班");

        Student student1 = BeanUtils.instantiateClass(Student.class);
        BeanUtils.copyProperties(student,student1);
        student1.setGrade("3年1班");

        System.out.println(student);
        System.out.println(student1);

        System.out.println(Objects.equals(student, student1));

        System.out.println(Objects.hash(student.getAge(), student.getGender()));

        System.out.println("------------------------------------");

        String[] string1 = {"1","2","3","4","zhen"};
        String[] string2 = string1;
        System.out.println(Objects.deepEquals(string1, string2));

        String[] string3 = {"1","2","3","4","zhen"};

        System.out.println(Objects.deepEquals(string1, string3));

        System.out.println(Objects.deepEquals(null, null));


    }
}
