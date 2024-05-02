package com.zx.create.abstractfactory;

import com.zx.create.abstractfactory.service.Doctor;
import com.zx.create.abstractfactory.service.Teacher;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 13:44 <br>
 * </p>
 *
 * @author zhou  xun
 */
public abstract class PersonAbstractFactory {
    /**
     * 获取医生
     *
     * @param doctorName 医生名称
     * @return {@link Doctor}
     * @author zhou  xun
     * @since 2024-03-22
     */
    public abstract Doctor getDoctor(String doctorName);

    /**
     * 获取教师
     *
     * @param teacherName 教师名称
     * @return {@link Teacher}
     * @author zhou  xun
     * @since 2024-03-22
     */
    public abstract Teacher getTeacher(String teacherName);
}
