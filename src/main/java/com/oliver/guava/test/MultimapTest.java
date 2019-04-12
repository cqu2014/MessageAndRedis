package com.oliver.guava.test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * @Author Oliver Wang
 * @Description 一键多值的Guava集合
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/4/4
 * @Since
 */
public class MultimapTest {
    public static void main(String[] args) {
        Multimap<String,String> multimap = ArrayListMultimap.create();
        //增加元素到map中
        multimap.put("fruits","Banana");
        multimap.put("fruits","Apple");
        multimap.put("fruits","Pear");
        multimap.put("fruits","Pear");
        multimap.put("vegetables","Carrot");

        System.out.println(multimap);

        System.out.println(multimap.containsKey("fruits"));
        System.out.println(multimap.containsValue("carrot"));

        //Multimap的size表示的是map中总的key-value对
        System.out.println(multimap.size());

        //multimap.get(key)返回的是一个Collection[注意]
        Collection<String> fruits = multimap.get("fruits");
        System.out.println(fruits);
        System.out.println(ImmutableSet.copyOf(fruits));

        Collection<String> vegetables = multimap.get("vegetables");
        System.out.println(vegetables);

        //返回MultiSet记录Key关联values的数目
        System.out.println(multimap.keys());

        //Multimap的keySet和valueSet
        System.out.println(multimap.keySet());
        System.out.println(multimap.values());

        //删除单个value
        multimap.remove("fruits","Pear");
        System.out.println(fruits);

        //删除key下的所有数据
        multimap.removeAll("fruits");
        System.out.println(multimap);
        System.out.println(fruits);

    }
}
