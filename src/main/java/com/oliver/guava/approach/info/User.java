package com.oliver.guava.approach.info;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Oliver Wang
 * @Description Redi缓存验证数据
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    /**
    * 
    */
    private Long id;
    
    /**
    * 
    */
    private String firstName;
    
    /**
    * 
    */
    private String lastName;
}
