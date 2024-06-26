package com.zx.java8;

import com.github.jsonzou.jmockdata.JMockData;
import com.zx.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StreamTest {
    @Test
    public void filterTest() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        // 过滤出以字母 a 开头的单词
        List<String> result = words.stream().filter(word -> word.startsWith("a"))
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertEquals("apple", result.get(0));
    }

    @Test
    public void groupByTest() {
        List<User> userList = Stream.of(JMockData.mock(User.class), JMockData.mock(User.class), JMockData.mock(User.class))
                .collect(Collectors.toList());
        Map<String, List<User>> map = userList.stream().collect(groupingBy(User::getName));
        map.forEach((s, users) -> System.out.printf("key is %s,value is %s%n", s, users));
    }

    @Test
    public void listMapGroupByTest() {
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("name", "xiao xun");
        studentMap.put("age", "18");
        studentMap.put("gender", "male");
        studentMap.put("className", "5");
        studentMap.put("grade", "13");
        studentMap.put("schoolName", "You guess");
        listMap.add(studentMap);
        Map<String, Map<String, Map<String, List<Map<String, Object>>>>> groupedlistMap = listMap.stream()
                .collect(groupingBy(map -> (String) map.get("grade"),
                        groupingBy(map -> (String) map.get("className"),
                                groupingBy(map -> (String) map.get("name")))));
        System.out.println(groupedlistMap);
    }

    @Test
    public void countTest() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3
    }

    @Test
    public void matchTest() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
    }

    @Test
    public void mapTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 将每个数字平方
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        assertEquals(5, squares.size());
        assertEquals(Integer.valueOf(1), squares.get(0));
        assertEquals(Integer.valueOf(4), squares.get(1));
        assertEquals(Integer.valueOf(9), squares.get(2));
        assertEquals(Integer.valueOf(16), squares.get(3));
        assertEquals(Integer.valueOf(25), squares.get(4));
    }

    @Test
    public void flatMapTest() {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        // 将二维数组转为一维数组
        List<Integer> result = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
        assertEquals(6, result.size());
        assertEquals(Integer.valueOf(1), result.get(0));
        assertEquals(Integer.valueOf(2), result.get(1));
        assertEquals(Integer.valueOf(3), result.get(2));
        assertEquals(Integer.valueOf(4), result.get(3));
        assertEquals(Integer.valueOf(5), result.get(4));
        assertEquals(Integer.valueOf(6), result.get(5));
    }

    @Test
    public void sortedTest() {
        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
        // 对数字进行排序
        List<Integer> result = numbers.stream().sorted().collect(Collectors.toList());
        Consumer<Integer> consumer = System.out::println;
        result.forEach(consumer);
        assertEquals(5, result.size());
        assertEquals(Integer.valueOf(1), result.get(0));
        assertEquals(Integer.valueOf(2), result.get(1));
        assertEquals(Integer.valueOf(3), result.get(2));
        assertEquals(Integer.valueOf(4), result.get(3));
        assertEquals(Integer.valueOf(5), result.get(4));
    }

    @Test
    public void distinctTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        // 去除数字中的重复元素
        List<Integer> result = numbers.stream().distinct().collect(Collectors.toList());
        assertEquals(4, result.size());
        assertEquals(Integer.valueOf(1), result.get(0));
        assertEquals(Integer.valueOf(2), result.get(1));
        assertEquals(Integer.valueOf(3), result.get(2));
        assertEquals(Integer.valueOf(4), result.get(3));
    }

    @Test
    public void reduceTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 对数字求和
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(15, sum);
    }

    @Test
    public void forEachTest() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        // 输出每个单词
        words.stream().filter(str -> !StringUtils.isEmpty(str)).forEach(System.out::println);
    }

    @Test
    public void limitTest() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> collect = words.stream().limit(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void skipTest() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> collect = words.stream().skip(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
