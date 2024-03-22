package com.zx.create.Singleton.impl;

import com.zx.create.Singleton.Singleton;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 15:35 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class StaticInnerClassSingleton implements Singleton {


    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void showMessage() {
        System.out.println("懒加载,线程安全,登记式/静态内部类");

    }
}
