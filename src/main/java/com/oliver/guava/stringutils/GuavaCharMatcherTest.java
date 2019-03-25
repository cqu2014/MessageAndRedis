package com.oliver.guava.stringutils;

import com.google.common.base.CharMatcher;

/**
 * @Author Oliver Wang
 * @Description CharMatcher提供了各种方法来处理各种JAVA char类型值
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/22
 * @Since
 */
public class GuavaCharMatcherTest {
    public static void main(String[] args) {
        //删除非a字符
        System.out.println(CharMatcher.isNot('a').removeFrom("abacd"));
        //删除a
        System.out.println(CharMatcher.is('a').removeFrom("abacd"));

        System.out.println(CharMatcher.whitespace().replaceFrom("a bcd", 'f'));

        //System.out.println(CharMatcher.digit().replaceFrom("a3bcd", "Three"));

        System.out.println(CharMatcher.anyOf("ab").trimFrom("abacatabb"));

        System.out.println(CharMatcher.anyOf("ab").trimLeadingFrom("abacatabb"));

    }
}
