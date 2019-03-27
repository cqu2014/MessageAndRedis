package com.oliver.guava.approach.info;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Oliver Wang
 * @Description 模板行数据
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/26
 * @Since
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TemplateInfo implements Serializable {

    private String language;

    private List<String> siteUid;

    private String fromMail;

    private TemplateContent content;
}
