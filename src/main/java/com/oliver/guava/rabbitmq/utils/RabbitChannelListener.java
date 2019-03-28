package com.oliver.guava.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ChannelListener;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description 用于监听通道的创建和销毁
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Service
@Slf4j
public class RabbitChannelListener implements ChannelListener {
    @Override
    public void onCreate(Channel channel, boolean transactional) {
        log.info("======================onCreate channel: {}, transactional: {}", channel, transactional);
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        // 可根据isHardError判断是channel断开还是connection断开
        if(signal.isHardError()){
            AMQImpl.Connection.Close close = (AMQImpl.Connection.Close) signal.getReason();
            log.warn("=====================Connection onShutDown replyCode: {}, methodId: {}, classId: {}, replyText: {}",
                    close.getReplyCode(), close.getMethodId(), close.getClassId(), close.getReplyText());
        }else {
            AMQImpl.Channel.Close close = (AMQImpl.Channel.Close) signal.getReason();
            log.warn("=====================Channel onShutDown replyCode: {}, methodId: {}, classId: {}, replyText: {}",
                    close.getReplyCode(), close.getMethodId(), close.getClassId(), close.getReplyText());
        }
    }
}
