package com.zx.create.abstractfactory.factory;

import com.zx.create.abstractfactory.PersonAbstractFactory;
import com.zx.create.abstractfactory.service.Doctor;
import com.zx.create.abstractfactory.service.Teacher;
import com.zx.create.abstractfactory.service.impl.Endocrinologist;
import com.zx.create.abstractfactory.service.impl.Surgeon;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 14:05 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class DoctorFactory extends PersonAbstractFactory {

    /**
     * 获取医生
     *
     * @param doctorName 医生名称
     * @return {@link Doctor}
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public Doctor getDoctor(String doctorName) {
        if ("out".equals(doctorName)) {
            return new Surgeon();
        }
        if ("in".equals(doctorName)) {
            return new Endocrinologist();
        }
        return null;
    }

    /**
     * 获取教师
     *
     * @param teacherName 教师名称
     * @return {@link Teacher}
     * @author zhou  xun
     * @since 2024-03-22
     */
    @Override
    public Teacher getTeacher(String teacherName) {
        return null;
    }
}
