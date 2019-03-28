package com.oliver.guava.rabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.oliver.guava.approach.info.User;
import com.oliver.guava.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Oliver Wang
 * @Description 消费者2
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Component
@RabbitListener(queues = RabbitMQConstant.OLIVER_QUEUE_NAME,containerFactory = "pointTaskContainerFactory")
@Slf4j
public class OliverRabbitSecondConsumer {

    @RabbitHandler
    public void processSecond(User user){
        log.info("Second Receiver [{}]:user = [{}]", Thread.currentThread().getName(),JSON.toJSONString(user));
    }
}
