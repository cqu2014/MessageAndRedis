package com.oliver.guava.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Strings;
import com.oliver.guava.approach.info.TemplateInfo;
import com.oliver.guava.dao.TemplatePo;
import com.oliver.guava.dto.FindTemplateParams;
import com.oliver.guava.mapper.TemplatePoMapper;
import com.oliver.guava.service.ITemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/26
 * @Since
 */
@Service
@Slf4j
public class TemplateServiceIpml implements ITemplateService {
    @Autowired
    TemplatePoMapper templatePoMapper;

    @Override
    public Optional<TemplatePo> queryById(Integer id) {
        log.info("queryById:input data [{}]",id);
        TemplatePo templatePo;
        try {
            templatePo = templatePoMapper.selectByPrimaryKey(id);

            log.info("queryById:output data [{}]", templatePo.getEmailType());
            return Optional.ofNullable(templatePo);
        }catch (Exception ex){
            log.error("queryById查询数据库异常{}",ex);
            throw ex;
        }
    }

    @Override
    public Optional<TemplateInfo> findTemplate(FindTemplateParams params) {
        log.info("findTemplate:input data [{}]", JSON.toJSONString(params));
        TemplatePo templatePo = null;
        try {
            templatePo = templatePoMapper.queryTemplate(params.getBrand(),params.getEmailType());
            log.info("findTemplate:查询数据库成功:{}",templatePo == null?null:templatePo.getEmailType());
        }catch (Exception ex){
            log.error("findTemplate: 查询数据库异常{}",ex);
            throw ex;
        }

        if (Objects.isNull(templatePo) || Strings.isNullOrEmpty(templatePo.getEmailTemplateList())){
            return Optional.empty();
        }

        //转化成对象
        List<TemplateInfo> templateInfos = JSONArray.parseArray(templatePo.getEmailTemplateList(),TemplateInfo.class);

        if (CollectionUtils.isEmpty(templateInfos)){
            return Optional.empty();
        }

        return templateInfos.stream()
                .filter(x->params.getLanguage().equals(x.getLanguage()))
                .filter(x->x.getSiteUid().contains(params.getSiteUid()))
                .findAny();
    }
}
