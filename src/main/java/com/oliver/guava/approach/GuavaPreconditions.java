package com.oliver.guava.approach;

import com.google.common.base.Preconditions;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/16
 * @Since
 */
public class GuavaPreconditions {
    public static void main(String[] args) {
        GuavaPreconditions guavaPreconditions = new GuavaPreconditions();

        try {
            guavaPreconditions.checkAgr(99L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            guavaPreconditions.checkState();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            guavaPreconditions.checkNotNull(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("checkPosition " + guavaPreconditions.checkPosition(17));

            System.out.println("checkElement " + guavaPreconditions.checkElement(17));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkAgr(Long lon) {
        Preconditions.checkArgument(lon > 100, "The input is to small");

        System.out.println(lon);
    }

    private void checkState() {
        Preconditions.checkState(System.nanoTime() > Long.MAX_VALUE, "It is a joking");
    }

    private void checkNotNull(int a) {
        Integer var1 = a > 10 ? a : null;
        Preconditions.checkNotNull(var1, "var1 is null");
    }

    private int checkElement(int index) {
        String str = "abcdefghijklmnopq";

        return Preconditions.checkElementIndex(index, str.length(), "checkElement: 17 抛出异常");
    }

    private int checkPosition(int index) {
        String str = "abcdefghijklmnopq";

        return Preconditions.checkPositionIndex(index, str.length(), "checkPosition: 17 不抛出异常");
    }
}
