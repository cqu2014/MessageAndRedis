package com.oliver.guava.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;

/**
 * @Author Oliver Wang
 * @Description Ordering(排序)可以被看作是一个丰富的比较具有增强功能的链接，
 * 多个实用方法，多类型排序功能等
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class OrderingTest {

    private static final int NINE = 9;

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        System.out.println("naturalOrdering:" + Ordering.natural().sortedCopy(list));
        System.out.println("usingToStringOrdering:" + Ordering.usingToString().sortedCopy(list));
        System.out.println("arbitraryOrdering:" + Ordering.arbitrary().sortedCopy(list));
        System.out.println("original:" + list);
        System.out.println("----------------------------------------");

        List<String> arrayList = Lists.newArrayList();
        arrayList.add("peida");
        arrayList.add("jerry");
        arrayList.add("harry");
        arrayList.add("eva");
        arrayList.add("jhon");
        arrayList.add("neron");

        System.out.println("arrayList:" + arrayList);

        Ordering<String> naturalOrdering = Ordering.natural();
        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(arrayList));
        System.out.println("----------------------------------");

        List<Integer> listTest = Lists.newArrayList();
        listTest.add(1);
        listTest.add(1);
        listTest.add(1);
        listTest.add(2);

        /**
         * 自然顺序排序：数值大小 or 字典顺序
         */
        Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();

        System.out.println("listTest:" + listTest);
        System.out.println(naturalIntReduceOrdering.isOrdered(listTest));
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(listTest));

        List<Integer> listReduce = Lists.newArrayList();
        for (int i = NINE; i > 0; i--) {
            listReduce.add(i);
        }

        listReduce.add(5);

        System.out.println("naturalIntReduceOrdering:" + naturalIntReduceOrdering.sortedCopy(listReduce));
        System.out.println("listReduce:" + listReduce);
        System.out.println(naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));

        System.out.println("----------------------------------------------------");

        Ordering<String> natural = Ordering.natural();
        List<String> abc = ImmutableList.of("a","b","c");

        System.out.println(natural.isOrdered(abc));
        System.out.println(natural.isStrictlyOrdered(abc));
        System.out.println(natural.reverse().sortedCopy(abc));

        System.out.println("------------------------------------------------");

        List<String> cba = ImmutableList.of("c","b","a");

        System.out.println(natural.isOrdered(cba));
        System.out.println(cba = natural.sortedCopy(cba));
        System.out.println(natural.max(cba));
        System.out.println(natural.min(cba));

        System.out.println("-----------------------------------------------");

        System.out.println("leastOf:"+natural.leastOf(cba, 2));
        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));
        System.out.println("leastOf list:"+naturalOrdering.leastOf(list, 3));
        System.out.println("greatestOf:"+naturalOrdering.greatestOf(list, 3));
        System.out.println("reverse list :"+ naturalOrdering.reverse().sortedCopy(list));
        System.out.println("isOrdered list :"+ naturalOrdering.isOrdered(list));
        System.out.println("isOrdered list :"+ naturalOrdering.reverse().isOrdered(list));
        list.add(null);
        System.out.println(" add null list:"+list);
        System.out.println("nullsFirst list :"+ naturalOrdering.nullsFirst().sortedCopy(list));
        System.out.println("nullsLast list :"+ naturalOrdering.nullsLast().sortedCopy(list));

        System.out.println("naturalIntReduceOrdering.onResultOf: "+
                naturalIntReduceOrdering.onResultOf((Integer x) -> x+2)
                .sortedCopy(listReduce));
    }
}
