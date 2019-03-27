package com.oliver.guava.approach.info;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Oliver Wang
 * @Description 模板内容
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/26
 * @Since
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TemplateContent implements Serializable {

    private String emailTitle;

    private String emailType;

    private String emailTemplateContent;
}
