package com.oliver.guava.stringutils;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class SplitterTest {
    public static void main(String[] args) {
        //返回不可变列表
        List<String> strList = Splitter.on(",").splitToList("a,_b,c__");
        System.out.println("4.字符串分割转List："+strList);

        // 5.字符串转Map
        Map<String,String> strMap = Splitter.on(";").trimResults().withKeyValueSeparator("=").split("a=2;b=3");
        System.out.println("5.字符串分割转Map："+strMap);


    }
}
