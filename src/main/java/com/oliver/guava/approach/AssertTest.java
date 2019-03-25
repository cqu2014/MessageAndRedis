package com.oliver.guava.approach;

import com.oliver.guava.approach.info.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/19
 * @Since
 */
public class AssertTest {
    public static void main(String[] args) {
        Student student = BeanUtils.instantiateClass(Student.class);
        student.setId(666)
                .setAge(100)
                .setGender("male")
                .setName("尼古拉斯·徐迪")
                .setGrade("3年1班");
        int a = 10;

        Assert.isInstanceOf(Student.class,student,"白马非马");
        System.out.println("------------------------------");

        Assert.isInstanceOf(Integer.class,a,"白马非马");

        System.out.println("------------------------------");

    }
}
