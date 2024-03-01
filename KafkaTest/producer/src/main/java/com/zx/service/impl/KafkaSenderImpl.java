package com.zx.service.impl;

import com.zx.service.ISender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * <p>
 * description: MQ发送kafka实现  kafka Producer <br>
 * create: 2024-02-29 15:38 <br>
 * </p>
 *
 * @author zhou  xun
 */
@Slf4j
@Service("iSender")
public class KafkaSenderImpl implements ISender {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSenderImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    /**
     * mq发送接口
     *
     * @param data 发送的消息
     * @author zhou  xun
     * @since 2024-02-29
     */
    @Override
    public void sender(String data) {
        ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) this.kafkaTemplate.send("test_kafka", data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("成功发送消息：{}，offset=[{}]", data, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("消息：{} 发送失败，原因：{}", data, ex.getMessage());
            }
        });
    }
}
