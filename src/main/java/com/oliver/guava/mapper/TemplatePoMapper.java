package com.oliver.guava.mapper;

import com.oliver.guava.dao.TemplatePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("templatePoMapper")
public interface TemplatePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplatePo record);

    int insertSelective(TemplatePo record);

    /**
     * 根据id查询模板
     *
     * @param id
     * @return
     */
    TemplatePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplatePo record);

    int updateByPrimaryKeyWithBLOBs(TemplatePo record);

    int updateByPrimaryKey(TemplatePo record);

    @Select("select * from system_email where brand = #{brand} and email_type = #{emailType}")
    @ResultMap("ResultMapWithBLOBs")
    TemplatePo queryTemplate(@Param("brand") String brand, @Param("emailType") String emailType);
}