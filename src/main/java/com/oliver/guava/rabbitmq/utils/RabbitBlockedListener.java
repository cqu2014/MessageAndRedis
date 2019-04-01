package com.oliver.guava.rabbitmq.utils;

import com.rabbitmq.client.BlockedListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description RabbitBlockedListener 是监听连接阻塞情况的监听器
 *              在Rabbit链接建立时设置
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/29
 * @Since
 */
@Service
@Slf4j
public class RabbitBlockedListener implements BlockedListener {
    @Override
    public void handleBlocked(String reason) {
        log.info("handleBlocked: connect is blocked reason=[{}]",reason);
    }

    @Override
    public void handleUnblocked() {
        log.info("**************connection unblocked**********");
    }
}
