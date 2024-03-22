package com.zx.create.abstractfactory.service.impl;

import com.zx.create.abstractfactory.service.Doctor;

import javax.print.Doc;

/**
 * <p>
 * description: 内分泌科医生 <br>
 * create: 2024-03-22 14:00 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Endocrinologist implements Doctor {
    private final String name = "内分泌科医生";

    /**
     * 治疗
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void treat() {
        System.out.println(this.name + ":你的病要想好,请远离女人知道吗？悠着点!");
    }
}
