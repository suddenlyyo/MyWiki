package com.zx.java8;

import com.github.jsonzou.jmockdata.JMockData;
import com.zx.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 函数式接口测试
 */
public class FunctionalInterfacesTest {
    @Test
    @DisplayName("Consumers Test")
    public void consumersTest() {
        // 创建一个Consumer，它接受一个User参数并打印用户名
        //表示接受单个输入参数但不返回任何结果的操作
        Consumer<User> greeter = (u) -> System.out.println("Hello, " + u.getName());
        //accept接口方法负责接收真实的参数
        greeter.accept(JMockData.mock(User.class));
    }

    @Test
    @DisplayName("Consumers andThen Test")
    public void consumersAndThenTest() {
        //Consumer接口的andThen方法允许你将一个Consumer与另一个Consumer链接在一起。
        // 第一个Consumer首先执行，然后执行第二个Consumer。这允许你在一个操作完成后执行另一个操作。

        // 创建一个Consumer，它接受一个字符串参数并打印该字符串
        Consumer<String> firstConsumer = str -> System.out.println("First Consumer: " + str);

        // 创建一个Consumer，它接受一个字符串参数并将该字符串转换为大写
        Consumer<String> secondConsumer = str -> System.out.println("Second Consumer: " + str.toUpperCase());

        // 将两个Consumer链接在一起，第一个Consumer首先执行，然后执行第二个Consumer
        Consumer<String> composedConsumer = firstConsumer.andThen(secondConsumer);

        // 使用组合的Consumer对字符串进行操作
        composedConsumer.accept("Hello World!");
    }

    @Test
    @DisplayName("Suppliers Test")
    public void suppliersTest() {
//        Supplier<User> userSupplier = User::new;
//        User user = userSupplier.get();// new User
//        System.out.println(user);// 返回的是应该空的user对象
        //延迟计算
        Supplier<LocalDateTime> currentTime = LocalDateTime::now;
        LocalDateTime now = currentTime.get(); // 获取当前时间
        //随机数生成
        Supplier<Double> randomDouble = Math::random;
        double rand = randomDouble.get(); // 产生一个随机数
    }

    @Test
    @DisplayName("Predicate Test")
    public void predicateTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 使用Lambda表达式定义一个判断偶数的Predicate
        Predicate<Integer> evenNumbers = (n) -> n % 2 == 0;
        // 使用filter方法过滤偶数并打印结果
        numbers.stream().filter(evenNumbers).forEach(System.out::println);
    }

    @Test
    @DisplayName("Predicate and Test")
    public void predicateAndTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 定义两个Predicate：判断是否是偶数和判断是否大于2
        Predicate<Integer> evenNumbers = (n) -> n % 2 == 0;
        Predicate<Integer> greaterThanTwo = (n) -> n > 2;
        // 使用and连接两个Predicate，过滤偶数且大于2的数字并打印结果
        numbers.stream().filter(evenNumbers.and(greaterThanTwo)).forEach(System.out::println);
    }
    @Test
    @DisplayName("Predicate or Test")
    public void predicateOrTest() {
        Predicate<String> startsWithA = s -> s.startsWith("A");

        Predicate<String> endsWithB = s -> s.endsWith("B");
        // 创建复合Predicate，判断字符串以"A"或"B"开头
        Predicate<String> eitherCondition = startsWithA.or(endsWithB);

        boolean meetsEither = eitherCondition.test("Apple");

        assertEquals(true,meetsEither);
    }

    @Test
    @DisplayName("Predicate isEqual Test")
    public void predicateIsEqualTest() {
        Predicate<String> isEqual = Predicate.isEqual("Hello");
        boolean result = isEqual.test("Hello");  // result will be true
        System.out.println(result);
    }

    @Test
    @DisplayName("Function Test")
    public void functionTest() {

        //Function接口提供了两个方法：compose和andThen，用于组合多个函数。
        //compose方法用于将多个函数组合成一个函数，从右到左执行。即先执行最右边的函数，并将其结果作为参数传递给左边的函数。
        //andThen方法用于将多个函数组合成一个函数，从左到右执行。即先执行最左边的函数，并将其结果作为参数传递给右边的函数。

        Function<Integer, Integer> doubleNumber = x -> x * 2;
        Function<Integer, Integer> increment = x -> x + 1;

        // 使用compose方法组合函数
        Function<Integer, Integer> composed = increment.compose(doubleNumber);
        System.out.println("Composed: " + composed.apply(5)); // 输出: Composed: 11

        // 使用andThen方法组合函数
        Function<Integer, Integer> andThen = doubleNumber.andThen(increment);
        System.out.println("AndThen: " + andThen.apply(5)); // 输出: AndThen: 11

    }


}


