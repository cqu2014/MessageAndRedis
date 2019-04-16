package com.oliver.guava.mapper;

import com.oliver.guava.dao.TemplatePo;
import org.springframework.stereotype.Component;

@Component("templatePoMapper")
public interface TemplatePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplatePo record);

    int insertSelective(TemplatePo record);

    TemplatePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplatePo record);

    int updateByPrimaryKeyWithBLOBs(TemplatePo record);

    int updateByPrimaryKey(TemplatePo record);
}