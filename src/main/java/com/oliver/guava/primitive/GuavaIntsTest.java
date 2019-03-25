package com.oliver.guava.primitive;

import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @Author Oliver Wang
 * @Description 整数Ints是原始的int类型的实用工具类
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/22
 * @Since
 */
public class GuavaIntsTest {
    public static void main(String[] args) {
        System.out.println(Ints.BYTES);
        Ints.checkedCast(123456789);

        System.out.println(Ints.contains(new int[]{1, 2, 3, 4, 5}, 1));

        System.out.println();

        System.out.println(Ints.fromByteArray(Ints.toByteArray(123456789)));
        //toArray

        List<Integer> list = Ints.asList(1,2,34,6,5,5,7);
        int[] aa = Ints.toArray(list);

        //asList
    }
}
