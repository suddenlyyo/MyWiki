package com.zx.controller;

import com.zx.api.ApiResponse;
import com.zx.param.MyRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-16 14:14 <br>
 * </p>
 *
 * @author zhou  xun
 */
@RestController
@Slf4j
public class TestValidationController {
    //@Validated与@Valid 的区别
    //@Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制，这个网上也有资料，不详述。
    //@Valid：作为标准JSR-303规范，还没有吸收分组的功能。
    @PostMapping("/create")
    public ApiResponse<Object> create(@Valid @RequestBody MyRequest request) {
        //@Valid 注解用于告诉 Spring Boot 对 MyRequest 对象进行验证。
        // 如果验证失败，将会抛出 MethodArgumentNotValidException 异常。

        // 业务逻辑处理

        return new ApiResponse<>(HttpStatus.OK.value(), "Success", request);

    }
}
