package com.oliver.guava.rabbitmq.utils;

import com.rabbitmq.client.Recoverable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Oliver Wang
 * @Description 监听自动重连的情况
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/27
 * @Since
 */
@Service
@Slf4j
public class RecoveryListener implements com.rabbitmq.client.RecoveryListener {

    @Override
    public void handleRecovery(Recoverable recoverable) {
        log.info("================handleRecovery: {}", recoverable);
    }

    @Override
    public void handleRecoveryStarted(Recoverable recoverable) {
        log.info("================handleRecoveryStarted: {}", recoverable);
    }
}
