package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * description:  kafkaMQ 测试<br>
 * create: 2024-02-29 14:51 <br>
 * </p>
 *
 * @author zhou  xun
 */
@SpringBootApplication
public class KafkaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class,args);
    }

}
