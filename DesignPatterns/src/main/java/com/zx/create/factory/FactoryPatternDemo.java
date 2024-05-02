package com.zx.create.factory;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-22 13:26 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal cat = animalFactory.create("Cat");
        cat.eat();
    }
}
