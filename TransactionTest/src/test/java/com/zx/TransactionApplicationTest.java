package com.zx;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: MyWiki
 * @description:
 * @author: zhou  xun
 * @create: 2023-12-18 14:25
 */
@SpringBootTest(classes = TransactionApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionApplicationTest {
}
