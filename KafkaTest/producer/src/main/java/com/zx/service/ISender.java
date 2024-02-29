package com.zx.service;

/**
 * <p>
 * description:  <br>
 * create: 2024-02-29 15:36 <br>
 * </p>
 *
 * @author zhou  xun
 */
public interface ISender {
    /**
     * mq发送接口
     * @param data 发送的消息
     * @author zhou  xun
     * @since 2024-02-29
     */
    void sender(String data);
}
