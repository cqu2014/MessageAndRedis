package com.oliver.guava.primitive;

import java.util.*;

/**
 * @Author Oliver Wang
 * @Description 多重映射接口扩展映射，使得其键一次可被映射到多个值
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/22
 * @Since
 */
public class GuavaMultimapTest {
    public static void main(String[] args) {
        Map<String, List<Integer>> stringListMap = new LinkedHashMap<>();
        Map<String, Set<String>>  stringSetMap = new LinkedHashMap<>();

        Map<String, TreeMap<String,Integer>> treeMapMap = new LinkedHashMap<>();
    }
}
