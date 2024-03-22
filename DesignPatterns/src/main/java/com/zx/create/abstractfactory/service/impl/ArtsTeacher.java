package com.zx.create.abstractfactory.service.impl;

import com.zx.create.abstractfactory.service.Teacher;

/**
 * <p>
 * description: 美术老师实现 <br>
 * create: 2024-03-22 13:50 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class ArtsTeacher implements Teacher {
    private final String name="美术老师";
    /**
     * 教育
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void education() {
        System.out.println(this.name+"在教学生没画画!");
    }
}
