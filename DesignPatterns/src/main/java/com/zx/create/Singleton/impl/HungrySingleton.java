package com.zx.create.Singleton.impl;

import com.zx.create.Singleton.Singleton;

/**
 * <p>
 * description: 饿汉模式单列 <br>
 * create: 2024-03-22 15:04 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class HungrySingleton implements Singleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public Singleton getInstance() {
        return instance;
    }

    @Override
    public void showMessage() {
        System.out.println("饿汉式不是懒加载,线程安全,缺点：类加载时就初始化，浪费内存");
    }
}
