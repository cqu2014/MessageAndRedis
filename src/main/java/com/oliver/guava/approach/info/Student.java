package com.oliver.guava.approach.info;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Oliver Wang
 * @Description 测试基础信息学生
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/18
 * @Since
 */
@Data
@Accessors(chain = true)
public class Student {
    /**
    * 学生编号
    */
    private int id;
    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private int age;
    /**
    * 班级信息
    */
    private String grade;

    public Student(){}
}

