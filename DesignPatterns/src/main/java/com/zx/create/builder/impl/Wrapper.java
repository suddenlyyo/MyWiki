package com.zx.create.builder.impl;

import com.zx.create.builder.Packing;

/**
 * <p>
 * description: 包装纸  <br>
 * create: 2024-05-02 15:30 <br>
 * </p>
 *
 * @author zhou  xun
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
