package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: MyWiki
 * @description:
 * @author: zhou  xun
 * @create: 2023-12-18 14:22
 */
@SpringBootApplication
@EnableTransactionManagement  //开启事务
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
