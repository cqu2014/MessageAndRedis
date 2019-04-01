package com.oliver.guava.rabbitmq.utils;

import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description 监听连接的创建和关闭
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Service
@Slf4j
public class RabbitConnectionListener implements ConnectionListener {
    @Autowired
    RabbitBlockedListener rabbitBlockedListener;

    @Override
    public void onCreate(Connection connection) {
        log.info("*********onCreate: {}********", connection);
        connection.addBlockedListener(rabbitBlockedListener);
    }

    @Override
    public void onClose(Connection connection) {
        log.info("*********onClose: {}*********", connection);
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        log.info("================onShutDown: {}", signal);
    }
}
