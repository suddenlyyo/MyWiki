package com.zx.handle;

import com.zx.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-16 14:29 <br>
 * </p>
 *
 * @author zhou  xun
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理方法参数无效异常
     *
     * @param ex MethodArgumentNotValidException
     * @return {@link ApiResponse<Object>}
     * @author zhou  xun
     * @since 2024-03-16
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        // 构建错误信息

        StringBuilder errorMessage = new StringBuilder();
        for (ObjectError objectError : globalErrors) {
            errorMessage.append(objectError.getDefaultMessage()).append("; ");
        }
        for (FieldError fieldError : fieldErrors) {
            errorMessage.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append("; ");
        }
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(), null);

    }
}
