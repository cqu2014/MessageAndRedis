package com.oliver.guava.rabbitmq.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description 消息发送到RabbitMQ交换器后接收ack回调
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Service
@Slf4j
public class ConfirmCallbackListener implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("ConfirmCallbackListener CorrelationData: {}, ack: {}, cause: {}", correlationData, ack, cause);
    }
}
