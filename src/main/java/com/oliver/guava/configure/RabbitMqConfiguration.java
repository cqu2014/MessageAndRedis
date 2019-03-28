package com.oliver.guava.configure;

import com.oliver.guava.configuration.RabbitMqPropertyConfiguration;
import com.oliver.guava.constant.RabbitMQConstant;
import com.oliver.guava.rabbitmq.utils.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author Oliver Wang
 * @Description 消息队列配置
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Configuration
public class RabbitMqConfiguration {

    @Autowired
    RabbitMqPropertyConfiguration propertyConfiguration;

    @Autowired
    ReturnCallBackListener returnCallBackListener;

    @Autowired
    ConfirmCallbackListener confirmCallbackListener;

    @Autowired
    RabbitChannelListener rabbitChannelListener;

    @Autowired
    RabbitConnectionListener rabbitConnectionListener;

    @Autowired
    RecoveryListener recoveryListener;

    /**
     * 私有生成 CachingConnectionFactory 方法
     *
     * @return
     */
    private CachingConnectionFactory getCachingConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(propertyConfiguration.getHost().concat(":").concat(propertyConfiguration.getPort()));
        cachingConnectionFactory.setUsername(propertyConfiguration.getUsername());
        cachingConnectionFactory.setPassword(propertyConfiguration.getPassword());
        cachingConnectionFactory.setVirtualHost(propertyConfiguration.getVirtualHost());
        cachingConnectionFactory.setPublisherConfirms(propertyConfiguration.isPublisherConfirms());
        cachingConnectionFactory.setPublisherReturns(propertyConfiguration.isPublisherReturns());
        cachingConnectionFactory.addChannelListener(rabbitChannelListener);
        cachingConnectionFactory.addConnectionListener(rabbitConnectionListener);
        cachingConnectionFactory.setRecoveryListener(recoveryListener);

        return cachingConnectionFactory;
    }


    /**
     * 用于消费者的 RabbitMq 连接
     * 功能类似于 rabbitTemplate.setUsePublisherConnection(true);
     *
     * @return
     */
    @Bean("consumer-connection-factory")
    public CachingConnectionFactory consumerCachingConnectionFactory() {
        return this.getCachingConnectionFactory();
    }

    /**
     * RabbitMq 主链接
     *
     * @return
     */
    @Bean
    @Primary
    public CachingConnectionFactory cachingConnectionFactory() {
        return this.getCachingConnectionFactory();
    }

    @Bean
    public RabbitTemplate getRabbitTemplate(CachingConnectionFactory cachingConnectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setConfirmCallback(confirmCallbackListener);
        /**
         * 当mandatory标志设置为true时
         * 如果exchange根据自身类型和消息的routingKey无法找到合适的queue存储消息
         * 那么broker会调用basic.return 方法将消息返回给生产者
         * 那么当mandatory设置为false时，出现上述情况broker会直接将消息丢弃
         */
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(returnCallBackListener);
        rabbitTemplate.setUsePublisherConnection(true);

        return rabbitTemplate;
    }


    /**
     * 设置消费者并发执行
     *
     * @param configurer
     * @param connectionFactory
     * @return
     */
    @Bean("pointTaskContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        //每次消费的数目
        factory.setPrefetchCount(RabbitMQConstant.DEFAULT_PREFETCH_COUNT);
        //消费者线程数据
        factory.setConcurrentConsumers(RabbitMQConstant.DEFAULT_CONCURRENT);
        //消费者线程最大数目
        factory.setMaxConcurrentConsumers(RabbitMQConstant.MAX_DEFAULT_CONCURRENT);
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
