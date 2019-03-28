package com.oliver.guava.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.oliver.guava.constant.RabbitMQConstant;
import com.oliver.guava.rabbitmq.productor.RabbitMQProductor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Author Oliver Wang
 * @Description RabbitM操作
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@RestController
@RequestMapping(value = "/rabbit")
@Slf4j
public class RabbitMqController {

    @Autowired
    RabbitMQProductor rabbitMQProductor;

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("rabbit-productor-%d").build();

    @GetMapping("product")
    public String productor() {
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(5,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),
                namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

        for (int i=0;i < RabbitMQConstant.DEFAULT_PREFETCH_COUNT;i++){
            executorService.execute(new MyThread());
        }

        return "SUCCESS";
    }

    class MyThread implements Runnable{

        @Override
        public void run() {
            rabbitMQProductor.send();
        }
    }
}
