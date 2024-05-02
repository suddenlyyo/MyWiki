package com.zx.create.builder.impl;

import java.math.BigDecimal;

/**
 * <p>
 * description: 百事可乐 <br>
 * create: 2024-05-02 15:51 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Pepsi extends ColdDrink {
    /**
     * 食物名称
     *
     * @return {@link String}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public String name() {
        return "Pepsi";
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
        return new BigDecimal("35.0");
    }
}
