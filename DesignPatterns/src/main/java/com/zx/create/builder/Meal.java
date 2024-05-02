package com.zx.create.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * description: 快餐套餐 <br>
 * create: 2024-05-02 15:23 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public BigDecimal getCost() {
        BigDecimal cost = items.stream().map(Item::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
