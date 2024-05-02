package com.zx.create.builder;

/**
 * <p>
 * description: 演示建造者模式 <br>
 * create: 2024-05-02 15:53 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
        System.out.println("--------------------------");
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
