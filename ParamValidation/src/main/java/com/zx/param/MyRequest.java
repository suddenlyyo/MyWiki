package com.zx.param;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-16 14:21 <br>
 * </p>
 *
 * @author zhou  xun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRequest {

    @NotNull(message = "ID不得为空")
    private Long id;

    @Size(min = 2, max = 10, message = "名称必须介于2到10个字符之间")
    private String name;
}