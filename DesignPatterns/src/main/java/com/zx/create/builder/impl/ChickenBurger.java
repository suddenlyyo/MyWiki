package com.zx.create.builder.impl;

import java.math.BigDecimal;

/**
 * <p>
 * description: 鸡肉汉堡 <br>
 * create: 2024-05-02 15:48 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class ChickenBurger extends Burger {
    /**
     * 食物名称
     *
     * @return {@link String}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public String name() {
        return "Chicken Burger";
    }

    /**
     * 获取价格
     *
     * @return {@link BigDecimal}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal("50.5");
    }
}
