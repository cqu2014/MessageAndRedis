package com.oliver.guava.service;

import com.oliver.guava.approach.info.TemplateInfo;
import com.oliver.guava.dao.TemplatePo;
import com.oliver.guava.dto.FindTemplateParams;

import java.util.Optional;

/**
 * @Author Oliver Wang
 * @Description 模板操作接口
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/26
 * @Since
 */
public interface ITemplateService {
    /**
     * 根据Id查询模板
     *
     * @param id
     * @return
     */
    Optional<TemplatePo> queryById(Integer id);

    /**
     *  find template with params
     *
     * @param params
     * @return
     */
    Optional<TemplateInfo> findTemplate(FindTemplateParams params);
}
