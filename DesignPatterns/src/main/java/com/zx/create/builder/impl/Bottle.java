package com.zx.create.builder.impl;

import com.zx.create.builder.Packing;

/**
 * <p>
 * description:  <br>
 * create: 2024-05-02 15:32 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
