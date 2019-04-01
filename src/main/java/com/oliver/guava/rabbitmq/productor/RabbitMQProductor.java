package com.oliver.guava.rabbitmq.productor;

import com.alibaba.fastjson.JSON;
import com.oliver.guava.approach.info.User;
import com.oliver.guava.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author Oliver Wang
 * @Description MQ生产者
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Component
@Slf4j
public class RabbitMQProductor{
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 数据生产者
     */
    public void send() {
        log.info("开始生产数据发哦RabbitMq[{}]", RabbitMQConstant.OLIVER_QUEUE_NAME);

        for (long i=0;i<RabbitMQConstant.PRODUCTOR_ONE_TOME;i++){
            User user = User.builder().id(i)
                    .firstName("erdog")
                    .lastName("xuda")
                    .build();

            String routingKey = RabbitMQConstant.OLIVER_ROUNT_KEY;
            if (i%10 == 0){
                routingKey = "BAD_ROUTING_KEY";
            }

            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(String.valueOf(88888888));

            rabbitTemplate.convertAndSend(RabbitMQConstant.OLIVER_EXCHAGE,
                    routingKey,user,correlationData);

            try {
                log.info("CorrelationData.Future = {}",
                        correlationData.getFuture().get(10, TimeUnit.SECONDS).isAck());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }

            log.info("product data [{}]",JSON.toJSONString(user));
        }
    }
}
