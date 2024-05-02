package com.zx.create.Singleton.impl;

import com.zx.create.Singleton.Singleton;

/**
 * <p>
 * description:双检锁/双重校验锁（DCL，即 double-checked locking）  <br>
 * create: 2024-03-22 15:10 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class DoubleCheckedLockingLazySingleton implements Singleton {

    //双重检查锁：
    //双检锁：单例模式中用volatile和synchronized来满足双重检查锁机制；
    //在实现单例模式的时候往往会忽略掉多线程的情况，就是写的代码在单线程的情况下是没问题的，但是一碰到多个线程的时候，由于代码没写好，就会引发很多问题，而且这些问题都是很隐蔽和很难排查的。而volatile（java5）：可以保证多线程下的可见性;
    //二次判空原因
    //第一次判断是为了验证是否创建对象，判断为了避免不必要的同步
    //第二次判断是为了避免重复创建单例，因为可能会存在多个线程通过了第一次判断在等待锁，来创建新的实例对象
    private volatile static DoubleCheckedLockingLazySingleton instance;

    private DoubleCheckedLockingLazySingleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingLazySingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public void showMessage() {
        System.out.println("懒加载,双检锁/双重校验锁,这种方式采用双锁机制，安全且在多线程情况下能保持高性能");
    }
}
