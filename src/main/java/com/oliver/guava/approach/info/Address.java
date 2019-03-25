package com.oliver.guava.approach.info;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Oliver Wang
 * @Description Redis缓存测试数据
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
@Data
@AllArgsConstructor
public class Address implements Serializable {
    /**
    * ID
    */
    private Long id;
    
    /**
    * 
    */
    private String province;
    
    /**
    * 
    */
    private String city;
}
