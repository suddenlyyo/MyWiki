package com.zx.java8;


import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/**
 * 重复注解测试
 */
public class RepeatableTest {
    //endregion
    public static void main(String[] args) {
        //获取注解信息
        Fruits[] annotationsByType = FruitDemo.class.getAnnotationsByType(Fruits.class);
        Arrays.stream(annotationsByType).
                forEachOrdered(fruits -> Arrays.stream(fruits.value())
                        .map(fruit -> fruit.name() + " is " + fruit.color())
                        .forEachOrdered(System.out::println));

    }

    //region定义重复注解
    @Repeatable(Fruits.class)
    public @interface Fruit {
        String name() default "";

        String color() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Fruits {
        Fruit[] value();
    }

    //endregion
    //region 使用重复注解
    @Fruits({
            @Fruit(name = "apple", color = "red"),
            @Fruit(name = "banana", color = "yellow")
    })
    static class FruitDemo {
    }

}
