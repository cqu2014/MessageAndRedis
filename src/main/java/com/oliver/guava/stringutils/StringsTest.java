package com.oliver.guava.stringutils;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.Map;

/**
 * @Author Oliver Wang
 * @Description google guava中定义的String操作
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
public class StringsTest {
    public static void main(String[] args) {
        /**
         * 判断字符创是否为null||""
         */
        String input = "";
        System.out.println(Strings.isNullOrEmpty(input));

        /**
         * 共同前缀和共同后缀
         */
        String a = "com.jd.coo.Hello";
        String b = "com.jd.coo.Hi";
        System.out.println(Strings.commonPrefix(a, b));

        String c = "com.google.Hello";
        String d = "com.jd.Hello";
        System.out.println(Strings.commonSuffix(c, d));

        /**
         * 补全字符串
         */
        int minLength = 4;
        System.out.println(Strings.padEnd("123", minLength, '0'));
        System.out.println(Strings.padStart("12", minLength, '0'));

        /**
         * Map的拆分与合并
         */
        String toSplitString = "a=b;c=d,e=f";
        Map<String,String> kvs = Splitter.onPattern("[;,]{1,}")
                .withKeyValueSeparator('=').split(toSplitString);
        System.out.println(kvs);
        System.out.println(Joiner.on(";").withKeyValueSeparator('=').join(kvs));



    }
}
