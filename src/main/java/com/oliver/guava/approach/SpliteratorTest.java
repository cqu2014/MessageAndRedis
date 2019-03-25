package com.oliver.guava.approach;

import java.util.*;
import java.util.function.IntConsumer;

import static java.util.Spliterators.spliterator;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/18
 * @Since
 */
public class SpliteratorTest {
    public static void main(String[] args) {
        List<String> oliver = Arrays.asList("hello","world","wang","oliver","zhen","hahahha");

        Spliterator<String> spliterators = spliterator(oliver,0);

        spliterators.forEachRemaining(System.out::println);

        int[] intArray = {1,2,3,4,5,6,7,8,9,0};

         Spliterator.OfInt aa =  Spliterators.spliterator(intArray,4);

         aa.tryAdvance((IntConsumer) System.out::println);
    }
}
