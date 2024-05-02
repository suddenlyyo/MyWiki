package com.zx.create.abstractfactory.service.impl;

import com.zx.create.abstractfactory.service.Teacher;

/**
 * <p>
 * description:数学老师实现  <br>
 * create: 2024-03-22 13:52 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class MathTeacher implements Teacher {
    private final String name = "数学老师";

    /**
     * 教育
     *
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public void education() {
        System.out.println(this.name + "在教学生加法");
    }
}
