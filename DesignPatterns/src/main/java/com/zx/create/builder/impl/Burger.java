package com.zx.create.builder.impl;

import com.zx.create.builder.Item;
import com.zx.create.builder.Packing;


/**
 * <p>
 * description: 汉堡包 <br>
 * create: 2024-05-02 15:33 <br>
 * </p>
 *
 * @author zhou  xun
 */
public abstract class Burger implements Item {
    /**
     * 汉堡用包装纸包装
     *
     * @return {@link Packing}
     * @author zhou  xun
     * @since 2024-05-02
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
