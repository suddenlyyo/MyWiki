package com.zx.create.abstractfactory;

import com.zx.create.abstractfactory.factory.DoctorFactory;
import com.zx.create.abstractfactory.factory.TeacherFactory;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 14:14 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class PersonFactoryProducer {
    public static PersonAbstractFactory getFactory(String choice) {
        if ("Doctor".equalsIgnoreCase(choice)) {
            return new DoctorFactory();
        } else if ("Teacher".equalsIgnoreCase(choice)) {
            return new TeacherFactory();
        }
        return null;
    }
}
