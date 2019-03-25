package com.oliver.guava.test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @Author Oliver Wang
 * @Description BiMap提供了一种新的集合类型，它提供了key和value的双向关联的数据结构
 *          会要求Value的唯一性
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class GuavaBimapTest {
    public static void main(String[] args) {
        BiMap<Integer,String> biMap = HashBiMap.create();
        biMap.put(1,"大狗");
        biMap.put(2,"二狗");
        biMap.put(3,"3 dog");
        biMap.put(4,"4 dog");
        //Bimap数据的强制唯一性
        //biMap.put(5,"4 dog");
        biMap.forcePut(5,"4 dog");
        System.out.println(biMap);
        System.out.println("---------------------------------------------");
        BiMap<String,Integer> inverseMap = biMap.inverse();
        System.out.println(inverseMap);

        inverseMap.forcePut("4 dog",4);

        System.out.println(biMap);
        System.out.println(inverseMap);
    }
}
