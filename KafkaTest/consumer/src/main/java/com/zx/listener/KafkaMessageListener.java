package com.zx.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * <p>
 * description: kafka consumer <br>
 * create: 2024-02-29 16:13 <br>
 * </p>
 *
 * @author zhou  xun
 */
@Component
public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);


    //基础消费方法 ，只能获取到生产的消息
    //监听多个topic时以逗号分割@KafkaListener(topics = "topic1, topic2")
    @KafkaListener(topics = "test_kafka", groupId = "boot-test-group")
    public void listen(String message) {
        logger.info("接收消息: {}", message);
    }

    //获取分区信息
    @KafkaListener(topics = "demo", groupId = "test-consumer")
    public void listenGetPartition(@Payload String message,
                                   @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("接收消息: {}，partition：{}", message, partition);
    }

    //指定只接收来自特定分区的消息
    @KafkaListener(topicPartitions = @TopicPartition(topic = "test",
            partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0")
            }),
            groupId = "test-consumer")
    public void listenByPartition(@Payload String message,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("接收消息: {}，partition：{}", message, partition);
    }
}
