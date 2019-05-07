package com.oliver.guava.approach.info;

import lombok.*;

import java.util.List;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
@Getter
@Builder
@ToString
public class People {
    /**
    * name
    */
    private String name;

    /**
    *
    */
    @Builder.Default
    private int  age = 100;
    
    /**
    *
    */
    private String  zhong;
    
    /**
    * 
    */
    @Singular
    private List<String> hobbies;
}
