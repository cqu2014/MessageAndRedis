package com.oliver.guava.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Oliver Wang
 * @Description RabbitMq的配置信息
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Data
@Component
public class RabbitMqPropertyConfiguration {
    private String host;
    private String port;
    private String username;
    private String password;
    private String virtualHost;
    /**
     * 生产者可以判断消息是否发送到了exchange
     */
    private boolean publisherConfirms;
    /**
     * 生产者可以判断消息是否发送到了queue
     * exchange是否找到了关联的 queue
     */
    private boolean publisherReturns;

}
