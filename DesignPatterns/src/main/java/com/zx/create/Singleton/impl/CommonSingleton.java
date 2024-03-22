package com.zx.create.Singleton.impl;

import com.zx.create.Singleton.Singleton;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 14:46 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class CommonSingleton implements Singleton {
    private static CommonSingleton instance;
    private CommonSingleton(){};
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new CommonSingleton();
        }
        return instance;
    }
    //懒加载（lazy loading）：需要时才初始化数据或对象
    @Override
    public void showMessage() {
        System.out.println("懒汉式，线程不安全");
    }
}
