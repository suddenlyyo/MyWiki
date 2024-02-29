package com.zx.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * @author xunzhou
 * @description queue模式的消费者
 */
@Component
public class QueueConsumerListener {

    @JmsListener(destination = "${spring.activemq.queue-name}",
            containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}