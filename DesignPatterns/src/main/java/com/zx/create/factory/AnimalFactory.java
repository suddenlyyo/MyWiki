package com.zx.create.factory;

import com.zx.create.factory.impl.Cat;
import com.zx.create.factory.impl.Dog;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 13:23 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class AnimalFactory {
    public Animal create(String name) {
        if ("Dog".equals(name)) {
            return new Dog();
        }
        if ("Cat".equals(name)) {
            return new Cat();
        }
        return null;
    }
}
