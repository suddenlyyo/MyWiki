package com.zx.create.abstractfactory.service.impl;

import com.zx.create.abstractfactory.service.Doctor;

/**
 * <p>
 * description: 外科医生 <br>
 * create: 2024-03-22 13:56 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Surgeon implements Doctor {
    private final String name = "外科医生";

    /**
     * 治疗
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void treat() {
        System.out.println(this.name + ":你的病看来得嘎腰子!");
    }
}
