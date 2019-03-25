package com.oliver.guava.approach;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * @Author Oliver Wang
 * @Description Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/16
 * @Since
 */
public class GuavaMultiset {
    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");

        System.out.println(multiset.contains("a"));

        System.out.println(multiset.containsAll(Arrays.asList("a", "d","e")));
        /**
         * 取元素的交集
         */
        multiset.retainAll(Arrays.asList("a", "d","e"));

        System.out.println(multiset);

        Spliterator<Integer> spliterator = Spliterators.emptySpliterator();
    }
}
