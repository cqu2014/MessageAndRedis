package com.oliver.guava.test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @Author Oliver Wang
 * @Description Table代表一个特殊的映射，其中两个键可以在组合的方式被指定为单个值。它类似于创建映射的映射
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class GuavaTableTest {
    public static void main(String[] args) {
        Table<String,Integer,String> atable = HashBasedTable.create();
        for(char a = 'A';a<= 'C';++a){
            for (Integer b = 1;b<=3;++b){
                atable.put(Character.toString(a),b,String.format("%c%d",a,b));
            }
        }

        System.out.println(atable);
        System.out.println(atable.rowKeySet());
        System.out.println(atable.columnKeySet());
        System.out.println("------------------------------------");
        /**
         * row和column返回的都是 column||row:value对组成的Map
         */
        System.out.println(atable.column(2));
        System.out.println(atable.row("B"));

        /**
         * value由(row,column)两个维度确定
         */
        System.out.println(atable.get("B", 2));

        System.out.println(atable.contains("D", 1));
        System.out.println(atable.containsColumn(3));
        System.out.println(atable.containsRow("C"));
        System.out.println("--------------------------------------------");
        System.out.println(atable.columnMap());
        System.out.println(atable.rowMap());

        System.out.println(atable.columnKeySet());
        System.out.println(atable.rowKeySet());
        System.out.println("----------------------------------------------");

        System.out.println(atable.remove("B", 3));
        System.out.println(atable.get("B", 3));

        System.out.println(atable.cellSet());

    }
}
