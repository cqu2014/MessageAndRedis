package com.oliver.guava.service;

import com.oliver.guava.dto.Student;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2019/5/13
 * @since
 */
public class DeliverParams {
    /**
     * java方法参数传递：
     *  1、原始参数类型：传递的是一个副本，原始值不会改变
     *  2、引用参数类型：传递的是参数引用(堆内存地址)的一个副本，若方法中未改变改引用指向的地址，则方法中的处理会影响传递的参数值；
     *      若通过new申请内存改变了引用的值，则原始参数不会受影响
     *
     * @param args
     */
    public static void main(String[] args) {
       int a = 100;
       int b = 99;

       swap(100,99);
       System.out.println("a="+a+",b="+b);

        System.out.println("----------------------------------------");

        Student oldStu = Student.builder()
                .id(100)
                .name("ergou")
                .build();

        dealStudent(oldStu);
        System.out.println(oldStu);
    }


    public static void dealStudent(Student student){
        System.out.println(student);
        student = Student.builder()
                .id(99)
                .name("sangou")
                .build();

        System.out.println(student);
    }

    public static void swap(int a,int b){
        System.out.println("a="+a+",b="+b);
        a = a+b;
        b = a - b;
        a = a - b;
        System.out.println("a="+a+",b="+b);
    }

    public static int anInt(int b,int add){
        b = b+add;
        System.out.println("b=" + b);

        return b;
    }
}
