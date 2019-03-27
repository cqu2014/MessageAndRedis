package com.oliver.guava.service;

import com.alibaba.fastjson.JSON;
import com.oliver.guava.approach.info.Address;
import com.oliver.guava.approach.info.TemplateInfo;
import com.oliver.guava.approach.info.User;
import com.oliver.guava.dao.TemplatePo;
import com.oliver.guava.dto.FindTemplateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author Oliver Wang
 * @Description Redis缓存业务层
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
@Service
@Slf4j
public class CacheService {
    @Autowired
    ITemplateService iTemplateService;

    /**
     * 从缓存中获取User
     *
     * @param id
     * @param firstName
     * @param lastName
     * @return
     */
    @Cacheable(value = "user_cache",key = "#id")
    public User findUser(Long id,String firstName,String lastName){
        log.info("findUser:无缓存的时候调用这里");
        return new User(id,firstName,lastName);
    }

    /**
     * 从缓存中获取Address
     *
     * @param id
     * @param province
     * @param city
     * @return
     */
    @Cacheable(value = "address_cache",keyGenerator = "oliverKeyGenerator")
    public Address findAddress(Long id,String province,String city){
        log.info("findAddress: 无缓存的时候调用这里");
        return new Address(id,province,city);
    }

    @Cacheable(value = "template_cache",keyGenerator = "oliverKeyGenerator")
    public TemplatePo queryTemplate(Integer id){
        log.info("queryTemplate: 触发了查找数据库");
        Optional<TemplatePo> templatePoOptional = iTemplateService.queryById(id);
        return templatePoOptional.get();
    }

    @Cacheable(value = "template_cache",key = "#params")
    public TemplateInfo queryTemplateInfo(FindTemplateParams params){
        return iTemplateService.findTemplate(params).orElse(null);
    }

}
