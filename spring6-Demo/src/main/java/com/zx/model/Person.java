package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MyWiki
 * @description: spring框架测试学习
 * @author: zhou  xun
 * @create: 2024-02-19 18:36
 */
@Data
public class Person {
    private  String name;
    private  Integer age;

    public Person() {
        System.out.println("调用了person 无参构造方法。。");
    }

    public Person(String name, Integer age) {
        System.out.println("调用了person 有参构造方法。。");
        this.name = name;
        this.age = age;
    }
}
