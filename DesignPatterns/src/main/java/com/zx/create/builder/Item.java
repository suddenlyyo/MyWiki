package com.zx.create.builder;

import java.math.BigDecimal;

/**
 * <p>
 * description: 食物条目 <br>
 * create: 2024-05-02 14:12 <br>
 * </p>
 *
 * @author zhou  xun
 */
public interface Item {
    /**
     * 食物名称
     *
     * @return {@link String}
     * @author zhou  xun
     * @since 2024-05-02
     */
    String name();

    /**
     * 获取包装方式
     *
     * @return {@link Packing}
     * @author zhou  xun
     * @since 2024-05-02
     */
    Packing packing();

    /**
     * 获取价格
     *
     * @return {@link BigDecimal}
     * @author zhou  xun
     * @since 2024-05-02
     */
    BigDecimal price();

}
