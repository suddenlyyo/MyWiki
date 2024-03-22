package com.zx.create.factory.impl;

import com.zx.create.factory.Animal;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 13:21 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Cat implements Animal {
    private final String name="小猫";
    /**
     * 吃
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void eat() {
        System.out.println(this.name+"在吃东西了!");
    }

    /**
     * 叫/喊
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void shout() {
        System.out.println(this.name+"在叫唤。。");
    }

    /**
     * 跑
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void run() {
        System.out.println(this.name+"跑过来了。。");
    }

    /**
     * 睡觉
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void sleep() {
        System.out.println(this.name+"它睡着了。。");
    }

    /**
     * 喝
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void drink() {
        System.out.println(this.name+"它在喝水。。");
    }
}
