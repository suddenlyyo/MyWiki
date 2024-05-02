package com.zx.create.builder.impl;

import com.zx.create.builder.Item;
import com.zx.create.builder.Packing;

/**
 * <p>
 * description:  <br>
 * create: 2024-05-02 15:42 <br>
 * </p>
 *
 * @author zhou  xun
 */
public abstract class ColdDrink implements Item {
    /**
     * 冷饮用瓶装
     *
     * @return {@link Packing}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
