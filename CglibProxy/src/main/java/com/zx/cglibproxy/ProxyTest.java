package com.zx.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @program: MyWiki
 * @description: cglib(子类代理测试类)
 * @author: zhou  xun
 * @create: 2024-02-02 09:31
 */
public class ProxyTest {
    //cglib 不支持Java9 以上版本，运行会报错
    public static void main(String[] args) {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置目标类
        enhancer.setSuperclass(Person.class);
        // 设置回调函数
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("Before method call");
            Object result = proxy.invokeSuper(obj, args1);
            System.out.println("After method call");
            return result;
        });
        // 创建代理对象
        Person proxy = (Person) enhancer.create();
        // 调用代理方法
        proxy.eat();

    }
}
