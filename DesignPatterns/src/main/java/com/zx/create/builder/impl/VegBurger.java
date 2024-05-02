package com.zx.create.builder.impl;

import java.math.BigDecimal;

/**
 * <p>
 * description: 素食汉堡 <br>
 * create: 2024-05-02 15:45 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class VegBurger extends Burger {
    /**
     * 食物名称
     *
     * @return {@link String}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public String name() {
        return "Veg Burger";
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
        return new BigDecimal("25.0");
    }
}
