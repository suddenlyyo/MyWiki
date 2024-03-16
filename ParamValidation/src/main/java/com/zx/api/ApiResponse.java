package com.zx.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * description: api响应对象  <br>
 * create: 2024-03-16 14:17 <br>
 * </p>
 *
 * @author zhou  xun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;
}
