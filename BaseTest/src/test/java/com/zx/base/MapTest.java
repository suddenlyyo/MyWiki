package com.zx.base;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * map 遍历
 */
public class MapTest {
    @Test
    public void keySet() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
//        for (String key : map.keySet()) {
//            System.out.println("Key: " + key + ", Value: " + map.get(key));
//        }
        map.keySet().stream()
                .map(key -> "Key: " + key + ", Value: " + map.get(key))
                .forEach(System.out::println);
    }

    @Test
    public void entrySet() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }

    @Test
    public void values() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
//        for (Integer value : map.values()) {
//            System.out.println("Value: " + value);
//        }
        map.values().stream()
                .map(value -> "Value: " + value)
                .forEach(System.out::println);
    }

    //----------------java8 新增方法测试--------------------------------------
//compute(key, BiFunction<? super K,? super V,? extends V> function)：此方法用于当给定一个键，该键在map中已存在时，
//通过提供的函数来计算新的值并更新到map中。如果该键不存在，则将该键值对插入到map中。
//computeIfAbsent(key, Function<? super K,? extends V> mappingFunction)：此方法用于当给定一个键，该键在map中不存在时，
//通过提供的函数来计算新的值并插入到map中。如果该键已经存在，则不会进行任何操作。
//computeIfPresent(key, BiFunction<? super K,? super V,? extends V> remappingFunction)：此方法用于当给定一个键，该键在map中已存在时，
//通过提供的函数来重新计算值并更新到map中。如果该键不存在，则不会进行任何操作。
//综上所述，这三个方法的主要区别在于它们处理键值对的条件不同。compute方法在给定键已存在时进行更新，computeIfAbsent方法在给定键不存在时插入新的键值对，
//而computeIfPresent方法在给定键已存在时重新计算值并进行更新。
    @Test
    public void compute() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        // 对于已经存在的key，通过函数计算新的值并更新
        map.compute("A", (key, value) -> value + 1);
        System.out.println(map.get("A")); // 输出：2
        // 对于不存在的key，通过函数计算新的值并插入到map中
        map.compute("C", (key, value) -> value == null ? 3 : value + 1);
        System.out.println(map.get("C")); // 输出：3
    }

    @Test
    public void computeIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        // 对于不存在的key，通过函数计算新的值并插入到map中
        map.putIfAbsent("C", 3);
        System.out.println(map.get("C")); // 输出：3
        // 对于已经存在的key，不会进行任何操作
        map.putIfAbsent("A", 4);
        System.out.println(map.get("A")); // 输出：1
    }

    @Test
    public void computeIfPresent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // 对于已经存在的key，通过函数重新计算新的值并更新
        map.computeIfPresent("A", (key, value) -> value + 1);
        System.out.println(map.get("A")); // 输出：2
    }

    @Test
    public void getOrDefault() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        //返回指定键映射到的值，或者 defaultValue 如果此映射不包含键的映射
        Integer orDefault = map.getOrDefault("C", 3);
        System.out.println(orDefault);// 输出：3
    }

    @Test
    public void merge() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        // 使用 merge 方法合并两个值
        map.merge("A", 5, Integer::sum);
        // 输出合并后的结果
        System.out.println(map);
    }

    @Test
    public void putIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        // 使用 putIfAbsent 方法添加键值对
        map.putIfAbsent("A", 1);
        map.putIfAbsent("B", 2);
        System.out.println("A: " + map.get("A")); // 输出：A: 1
        System.out.println("B: " + map.get("B")); // 输出：B: 2
        // 再次尝试添加键值对，因为键 "A" 已经存在，所以 putIfAbsent 方法不会更改现有的值
        map.putIfAbsent("A", 3);
        System.out.println("A: " + map.get("A")); // 输出：A: 1
    }

    @Test
    public void replace() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "b");
        if (!"not found".equals(map.getOrDefault("A", "not found"))) {
            map.replace("A", "new a");
        }
        System.out.println(map.get("A")); // 输出：new a
    }

    @Test
    public void replaceAll() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.replaceAll((key, value) -> value * 2);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

    }

    @Test
    public void treeMapTest() {
        // 创建一个 TreeMap 实例
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // 向 TreeMap 中添加元素
        treeMap.put("Apple", 10);
        treeMap.put("Banana", 5);
        treeMap.put("Cherry", 15);
        treeMap.put("Date", 8);

        // 遍历 TreeMap 中的元素
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }

        // 使用 firstKey(), lastKey() 和 subMap() 方法
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("SubMap from 'Banana' to 'Cherry':");
        TreeMap<String, Integer> subMap = (TreeMap<String, Integer>) treeMap.subMap("Banana", "Cherry");
        for (String key : subMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + subMap.get(key));
        }

        // 使用 lowerKey(), floorKey(), ceilingKey(), higherKey() 方法
        System.out.println("Lower key of 'Cherry': " + treeMap.lowerKey("Cherry"));
        System.out.println("Floor key of 'Cherry': " + treeMap.floorKey("Cherry"));
        System.out.println("Ceiling key of 'Banana': " + treeMap.ceilingKey("Banana"));
        System.out.println("Higher key of 'Banana': " + treeMap.higherKey("Banana"));
    }
}
