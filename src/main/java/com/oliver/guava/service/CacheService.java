package com.oliver.guava.service;

import com.oliver.guava.approach.info.Address;
import com.oliver.guava.approach.info.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description Redis缓存业务层
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/25
 * @Since
 */
@Service
public class CacheService {

    /**
     * 从缓存中获取User
     *
     * @param id
     * @param firstName
     * @param lastName
     * @return
     */
    @Cacheable(value = "user_cache",keyGenerator = "oliverKeyGenerator")
    public User findUser(Long id,String firstName,String lastName){
        System.out.println("findUser:无缓存的时候调用这里");
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
        System.out.println("findAddress: 无缓存的时候调用这里");
        return new Address(id,province,city);
    }


}
