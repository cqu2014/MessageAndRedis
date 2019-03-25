package com.oliver.guava.approach;

import com.oliver.guava.approach.info.People;

import java.util.Arrays;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class LombokTest {
    public static void main(String[] args) {
        People ergou = People.builder()
                .name("二狗")
                .hobby("apple")
                .hobbies(Arrays.asList("美女","帅哥"))
                .build();

        System.out.println(ergou);


    }
}
