package com.oliver.guava.constant;

/**
 * @Author Oliver Wang
 * @Description Rabbitmq连接相关的常亮设置
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
public class RabbitMQConstant {
    /**
     * MQ 队列名称
     */
    public static final String OLIVER_QUEUE_NAME = "middleRabbit";

    /**
    * MQ Exchange
    */
    public static final String OLIVER_EXCHAGE = "oliverExchange";

    /**
     * MQ routingKey
     */
    public static final String OLIVER_ROUNT_KEY = "oliverRoutingKey";

    /**
     * 每次消费的个数
     */
    public static final int DEFAULT_PREFETCH_COUNT = 10;

    /**
     * 消费者并发数目
     */
    public static final int DEFAULT_CONCURRENT = 3;

    /**
     * 消费者线程最大个数
     */
     public static final int MAX_DEFAULT_CONCURRENT = 5;
    /**
     * 生产者一次生产的数据
     */
    public static final int PRODUCTOR_ONE_TOME = 1000;
}
