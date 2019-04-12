package com.oliver.guava.stringutils;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Oliver Wang
 * @Description 根据给定的分隔符把字符串连接到一起
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class JoinerTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                null,"erdog","sandog",null,"sidog",null,"fivedog","sixdog"
        );

        Joiner joiner = Joiner.on("|");

        System.out.println(joiner.skipNulls().join(list));
        System.out.println(joiner.useForNull("666666").join(list));
        System.out.println("-------------------------------------------------");
        Joiner stringJoiner = Joiner.on("|").skipNulls();
        //就像Java8中流操作，useForNull返回一个新的Joiner独享，stringJoiner并没有发生变化
        System.out.println(Joiner.on("|").skipNulls().join("foo",null, "bar"));

    }
}
