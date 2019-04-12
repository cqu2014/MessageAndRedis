package com.oliver.guava.test;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Oliver Wang
 * @Description Guava提供一个强大的基于内存的缓存工具
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class GuavaCacheTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 定义数据加载器，数据从何而来
         */
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        /**
         * 使用辅助类定义 LoadingCache<key,value>
         */
        LoadingCache<String,String> cache = CacheBuilder.newBuilder()
                .build(loader);

        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.getUnchecked("oliver"));
        System.out.println(cache.asMap().toString());
        cache.invalidateAll();
        System.out.println(cache.asMap().toString());
        System.out.println("-------------------------------------------------");

        //设置cache的大小并将最老的驱逐
        LoadingCache<String,String> sizeCache = CacheBuilder.newBuilder()
                .maximumSize(3).build(loader);

        sizeCache.getUnchecked("aaaaa");
        sizeCache.getUnchecked("bbbbb");
        sizeCache.getUnchecked("ccccc");
        System.out.println(sizeCache.asMap().toString());
        sizeCache.getUnchecked("dddddd");
        System.out.println(sizeCache.asMap().toString());
        sizeCache.getUnchecked("eeeeeee");
        System.out.println(sizeCache.asMap().toString());
        System.out.println("-------------------------------------------------");

        //给元素设置权重并 按照权重驱逐
        Weigher<String,String> weigherByLength = (key, value) -> value.length();
        LoadingCache<String,String> weightCache = CacheBuilder.newBuilder()
                .maximumWeight(10)
                .weigher(weigherByLength)
                .build(loader);

        weightCache.getUnchecked("first");
        System.out.println(weightCache.asMap());
        weightCache.getUnchecked("second");
        System.out.println(weightCache.asMap());
        weightCache.getUnchecked("third");
        System.out.println(weightCache.asMap());
        weightCache.getUnchecked("four");
        System.out.println(weightCache.asMap());
        weightCache.getUnchecked("last");
        System.out.println(weightCache.asMap());
        weightCache.getUnchecked("111111111111");
        System.out.println(weightCache.asMap());
        System.out.println("--------------------------------");
        System.out.println(weightCache.getIfPresent("first"));
        System.out.println(weightCache.getIfPresent("111111111111"));
        System.out.println("--------------------------------------");

        /**
         * 设置缓存的失效时间
         */
        LoadingCache<String,String> timeCache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.SECONDS)
                .build(loader);

        timeCache.getUnchecked("hello");
        System.out.println(timeCache.asMap());
        Thread.sleep(5000);
        System.out.println(timeCache.asMap());
        System.out.println("---------------------------------------");

        /**
         * 定义并设置缓存的删除通知监听者
         */
        RemovalListener<String,String> listener = notification -> {
            if (notification.wasEvicted()){
                System.out.println(notification.getCause().name());
                System.out.println(RemovalCause.SIZE.toString());
            }
        };

        LoadingCache<String,String> removalCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);

        removalCache.getUnchecked("first");
        removalCache.getUnchecked("second");
        removalCache.getUnchecked("third");
        removalCache.getUnchecked("last");

        System.out.println(removalCache.asMap());
    }


}
