package com.oliver.guava.approach;

import com.oliver.guava.approach.info.Student;
import org.springframework.beans.BeanUtils;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class BeanCopyTest {
    public static void main(String[] args) {
        Student student = BeanUtils.instantiateClass(Student.class);
        student.setGrade("3年4班")
                .setName("徐大聪明")
                .setAge(10)
                .setGender("二狗同属性")
                .setId(1000);

        Student copyStudent = new Student();

        BeanUtils.copyProperties(student,copyStudent,"age","grade");

        System.out.println(copyStudent);

    }
}
