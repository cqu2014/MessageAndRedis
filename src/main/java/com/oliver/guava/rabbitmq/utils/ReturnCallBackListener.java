package com.oliver.guava.rabbitmq.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description 消息到达Exchange但无队列与其绑定时回调
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Service
@Slf4j
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("return message:{}, code: {}, text: {}, exhcange:{}, routingkey:{}", JSON.toJSONString(message), replyCode, replyText,
                exchange, routingKey);
    }
}
