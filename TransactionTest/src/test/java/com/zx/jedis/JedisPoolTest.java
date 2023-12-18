package com.zx.jedis;

import com.zx.TransactionApplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 jedis池测试
 */
public class JedisPoolTest extends TransactionApplicationTest {
    @Autowired
    private JedisPool jedisPool;

    @DisplayName("string Test")
    @Test
    void stringTest() {
        Jedis jedis = jedisPool.getResource();
        //调用对应的方法操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        //可存储指定过期时间的数据
        jedis.setex("activeCode", 20, "valueString");
        System.out.println(username);
        jedis.close();
    }

}
