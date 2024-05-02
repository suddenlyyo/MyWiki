package com.zx.create.builder;

import com.zx.create.builder.impl.ChickenBurger;
import com.zx.create.builder.impl.Coke;
import com.zx.create.builder.impl.Pepsi;
import com.zx.create.builder.impl.VegBurger;

/**
 * <p>
 * description:  <br>
 * create: 2024-05-02 15:52 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class MealBuilder {
    /**
     * 准备素食餐
     *
     * @return {@link Meal}
     * @author zhou  xun
     * @since 2024-05-02
     */
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 准备非素食餐
     *
     * @return {@link Meal}
     * @author zhou  xun
     * @since 2024-05-02
     */
    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
