package com.zx.model;

import lombok.Data;

/**
 * @program: MyWiki
 * @description: spring框架测试学习
 * @author: zhou  xun
 * @create: 2024-02-19 18:36
 */
@Data
public class Person {
    private String name;
    private Integer age;

    //类初始化顺序遵循以下三个原则（优先级依次递减）
// 1、静态对象（变量）优先于非静态对象（变量）初始化，其中静态对象（变量）只初始化一次，而非静态对象（变量）可能会初始化多次；
// 2、父类优先于子类初始化；
// 3、成员变量按照定义先后顺序进行初始化
    static {
        System.out.println("执行了静态初始化块。。");
    }

    public Person() {
        System.out.println("调用了person 无参构造方法。。");
    }

    public Person(String name, Integer age) {
        System.out.println("调用了person 有参构造方法。。");
        this.name = name;
        this.age = age;
    }
}
