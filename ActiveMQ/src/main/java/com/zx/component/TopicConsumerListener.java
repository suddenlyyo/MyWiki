package com.zx.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author xunzhou
 * @description topic模式的消费者
 */
@Component
public class TopicConsumerListener {
    @JmsListener(destination = "${spring.activemq.topic-name}",
            containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
    }
}