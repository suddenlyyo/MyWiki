package com.zx.param;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-16 16:44 <br>
 * </p>
 *
 * @author zhou  xun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyGroupRequest {
    // 定义分组
    public interface FirstGroup {}

    public interface SecondGroup {}

    // 定义分组顺序
    @GroupSequence({FirstGroup.class, SecondGroup.class})
    public interface AllGroups {}

    // 分组校验示例
    @NotNull(message = "ID不能为空", groups = FirstGroup.class)
    private Long id;

    @NotBlank(message = "姓名不能为空", groups = SecondGroup.class)
    private String name;

    @NotNull(groups = {FirstGroup.class, SecondGroup.class}, message = "密码不能为空")
    private String password;
}
