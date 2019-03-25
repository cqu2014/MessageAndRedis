package com.oliver.guava.controller;


import com.oliver.guava.approach.info.Address;
import com.oliver.guava.approach.info.User;
import com.oliver.guava.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
@RestController
@Slf4j
public class RedisCacheController {
    @Autowired
    CacheService cacheService;

    @GetMapping("/put")
    public String putCache(){
        cacheService.findUser(1L,"wang","Oliver");
        cacheService.findAddress(1L,"Anhui","HeFei");

        log.info("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");

        return "OK";
    }

    @GetMapping("/get")
    public String testCache(){
        User user = cacheService.findUser(1L,"wang","Oliver");
        Address address =cacheService.findAddress(1L,"Anhui","HeFei");
        log.info("我这里没执行查询");
        log.info("user:{}",user);
        log.info("address:{}",address);

        return "ok";
    }
}
