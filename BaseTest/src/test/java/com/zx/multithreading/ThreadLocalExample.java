package com.zx.multithreading;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>
 * description: 线程变量测试 <br>
 * create: 2024-03-16 13:43 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class ThreadLocalExample {
    // 创建一个 ThreadLocal 实例
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            // 为线程1设置 ThreadLocal 变量的值
            threadLocal.set(ThreadLocalRandom.current().nextInt(100));
            System.out.println("Thread 1 value: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            // 为线程2设置 ThreadLocal 变量的值（注意这与线程1的值不同）
            threadLocal.set(ThreadLocalRandom.current().nextInt(100));
            System.out.println("Thread 2 value: " + threadLocal.get());
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程结束
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 清除 ThreadLocal 变量（虽然在这个例子中不是必须的，因为线程已经结束了）
        threadLocal.remove();
    }
}
