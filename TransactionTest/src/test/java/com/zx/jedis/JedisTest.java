package com.zx.jedis;


import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * jedis测试
 */

public class JedisTest {

    @Test
    public void baseTest() {
        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
            System.out.println("redis如果存在key则不操作，否则设置：" + jedis.setnx("keys", "values"));
            System.out.println("判断某个键是否存在：" + jedis.exists("username"));
            System.out.println("新增<'username','ly'>的键值对：" + jedis.set("username", "ly"));
            System.out.println("新增<'password','123456'>的键值对：" + jedis.set("password", "123456"));
            System.out.print("系统中所有的键如下：");
            Set<String> keys = jedis.keys("*");
            System.out.println(keys);

            System.out.println("删除键password:" + jedis.del("password"));
            System.out.println("判断键password是否存在：" + jedis.exists("password"));
            System.out.println("查看键username所存储的值的类型：" + jedis.type("username"));
            System.out.println("随机返回key空间的一个：" + jedis.randomKey());
            System.out.println("重命名key：" + jedis.rename("username", "name"));
            System.out.println("取出改后的name：" + jedis.get("name"));
            System.out.println("按索引查询：" + jedis.select(0));
            System.out.println("删除当前选择数据库中的所有key：" + jedis.flushDB());
            System.out.println("返回当前数据库中key的数目：" + jedis.dbSize());
            System.out.println("删除所有数据库中的所有key：" + jedis.flushAll());
        }
    }
}
