package com.zx.create.builder.impl;

import java.math.BigDecimal;

/**
 * <p>
 * description: 可口可乐 <br>
 * create: 2024-05-02 15:50 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Coke extends ColdDrink {
    /**
     * 食物名称
     *
     * @return {@link String}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public String name() {
        return "Coke";
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
        return new BigDecimal("30.0");
    }
}
