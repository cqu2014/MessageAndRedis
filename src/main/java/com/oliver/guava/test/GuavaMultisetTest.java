package com.oliver.guava.test;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Oliver Wang
 * @Description Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class GuavaMultisetTest {
    public static void main(String[] args) {
        String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";

        String[] stringArray = strWorld.split("\\|");

        GuavaMultisetTest guavaMultisetTest = new GuavaMultisetTest();
        guavaMultisetTest.countSet(stringArray);

        /**
         * 从一个Collection中生成Multiset
         */
        Multiset<String> multiset = HashMultiset.create(Arrays.asList(stringArray));
        System.out.println(multiset.entrySet());
        System.out.println(multiset.elementSet());
        multiset.entrySet().forEach(x->
            System.out.println(x.getElement()+":"+x.getCount())
        );
        System.out.println("------------------------------------------------------");


    }

    private void countSet(String[] strings) {
        Assert.notEmpty(strings, "数组必须包含元素");
        List<String> linkedList = Arrays.asList(strings);

        Multiset<String> stringMultiset = HashMultiset.create(linkedList);
        stringMultiset.forEach((v) ->
                System.out.println(v + "-->" + stringMultiset.count(v))
                );
        System.out.println("-----------------------------------------");

    }
}
