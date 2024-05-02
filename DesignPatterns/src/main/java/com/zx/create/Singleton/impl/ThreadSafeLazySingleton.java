package com.zx.create.Singleton.impl;

import com.zx.create.Singleton.Singleton;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 14:58 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class ThreadSafeLazySingleton implements Singleton {
    private static ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazySingleton();
        }
        return instance;
    }

    @Override
    public void showMessage() {
        System.out.println("懒汉式，线程安全");
    }
}
