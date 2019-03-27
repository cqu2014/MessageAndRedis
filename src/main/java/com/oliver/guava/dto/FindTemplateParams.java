package com.oliver.guava.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Oliver Wang
 * @Description 查询模板参数
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/26
 * @Since
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindTemplateParams implements Serializable {
    /**
     * 邮件类型
     */
    @NotNull
    private String emailType;

    @NotNull
    private String brand;

    @NotNull
    private String language;
    /**
     * 站点
     */
    @NotNull
    private String siteUid;

    @Override
    public String toString(){
        return  "".concat(brand).concat("|")
                .concat(emailType).concat("|")
                .concat(language).concat("|")
                .concat(siteUid);
    }
}
