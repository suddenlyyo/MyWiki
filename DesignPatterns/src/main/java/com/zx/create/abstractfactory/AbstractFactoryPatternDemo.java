package com.zx.create.abstractfactory;

import com.zx.create.abstractfactory.service.Teacher;

import java.util.Optional;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 14:17 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        Optional<PersonAbstractFactory> teacher = Optional.ofNullable(PersonFactoryProducer.getFactory("teacher"));
        if (teacher.isPresent()) {
            PersonAbstractFactory personAbstractFactory = teacher.get();
            Optional<Teacher> math = Optional.ofNullable(personAbstractFactory.getTeacher("math"));
            if (math.isPresent()) {
                Teacher mathTeacher = math.get();
                mathTeacher.education();
            }
        }
    }
}
