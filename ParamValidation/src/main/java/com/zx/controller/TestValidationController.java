package com.zx.controller;

import com.zx.api.ApiResponse;
import com.zx.param.MyGroupRequest;
import com.zx.param.MyRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
    public ApiResponse<MyRequest> create(@Valid @RequestBody MyRequest request) {
        //@Valid 注解用于告诉 Spring Boot 对 MyRequest 对象进行验证。
        // 如果验证失败，将会抛出 MethodArgumentNotValidException 异常。

        // 业务逻辑处理

        return new ApiResponse<>(HttpStatus.OK.value(), "Success", request);

    }

    //对于同一个实体类的不同属性，不同的请求可能会有不同的校验规则。
    // 例如，在用户注册时，User类的id字段需要校验为空，因为User的id是由系统生成并维护的，而不是由用户自己填写的。
    // 然而，在修改用户密码时，又需要传入id作为where语句的条件去更新用户信息。
    // 这种情况下，分组校验就能很好地派上用场
    @PostMapping("/submit")
    public ApiResponse<MyRequest> submit(@Validated(MyGroupRequest.FirstGroup.class) @RequestBody MyRequest request) {
        // 处理请求
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", request);
    }

    @PostMapping("/update")
    public ApiResponse<MyRequest> update(@Validated(MyGroupRequest.SecondGroup.class) @RequestBody MyRequest request) {
        // 处理请求
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", request);
    }
}
