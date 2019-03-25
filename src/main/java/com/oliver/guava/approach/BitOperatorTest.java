package com.oliver.guava.approach;

/**
 * @Author Oliver Wang
 * @Description 位操作
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class BitOperatorTest {

    private static final int THIRTY_TWO = 32;

    public static void main(String[] args) {
       /* int num = 3;
        printNum(num);
        printNum(~num);
        printNum(-num);
        System.out.println("---------------------------------------");

        int seven = 5;
        printNum(num);
        printNum(seven);
        printNum(num&seven);
        System.out.println("--------------------------------");
        printNum(num);
        printNum(seven);
        printNum(num|seven);
        System.out.println("--------------------------------");
        printNum(num);
        printNum(seven);
        printNum(num^seven);
        System.out.println("--------------------------------");
        printNum(seven);
        printNum(seven<<num);
        System.out.println("--------------------------------");
        printNum(seven);
        printNum(seven>>1);*/

        /**
         * 交换两个数
         */
        int two = 2;
        int five = 5;

        two = two ^ five;
        five = five ^ two;
        two = two ^ five;

        System.out.println("two = " + two + "\n five = " + five);
        System.out.println("----------------------------------------");

        /**
         * 求2的N次幂 左移相当于 *2
         */
        System.out.println(1L << 32);
        System.out.println("---------------------------");

        /**
         * 判断奇偶 判断最后一位是否为0即可
         */
        int four = 4;
        int nine = 9;

        System.out.println(((four&1) == 1) ? "奇数" : "偶数");
        System.out.println(((nine&1) == 1) ? "奇数" : "偶数");

        /**
         * 求绝对值
         */
        int num = -3;
        System.out.println(Math.abs(num));
        int i = num >> 31;
        System.out.println(i == 0 ? num : (~num + 1));

    }

    /**
     * 二进制打印方法
     *
     * @param n
     */
    private static void printNum(int n) {
        String num = Integer.toBinaryString(n);

        if (num.length() == THIRTY_TWO) {
            System.out.println(num);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < THIRTY_TWO - num.length(); i++) {
                sb.append("0");
            }
            System.out.println(sb.toString() + num);
        }
    }
}
