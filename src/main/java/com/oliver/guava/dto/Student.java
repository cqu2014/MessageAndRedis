package com.oliver.guava.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2019/5/13
 * @since
 */
@Data
@Builder
public class Student {
    private int id;
    private String name;
}
