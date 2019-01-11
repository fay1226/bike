package com.fay.bike.app.configuration;

import com.fay.bike.base.enums.BaseCode;
import com.fay.bike.base.exception.SysException;
import com.fay.bike.base.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 异常拦截类
 * @author fanqingfeng
 * @date 2018/10/31 17:02
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Exception> handlerException(Exception e) {

        Result<Exception> result = new Result<>();

        //自定义异常
        if (e instanceof SysException) {
            SysException exception = (SysException) e;
            log.info(exception.getErrorMsg());
            return result.fail(exception, exception.getErrorMsg());
        }
        //权限不足
        if (e instanceof BadCredentialsException) {
            log.info(e.getMessage());
            return result.fail(BaseCode.NO_AUTHENTION);
        }
        //类型转换异常
        if (e instanceof TypeMismatchException) {
            log.warn(e.getMessage());
            return result.fail(BaseCode.PARAM_ERROR);
        }
        //MethodArgumentNotValidException方法参数校验异常
        if (e instanceof MethodArgumentNotValidException) {
            StringBuilder errorMsg = new StringBuilder();
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
            for (ObjectError error : errors) {
                if (errorMsg.length() > 0) {
                    errorMsg.append(",");
                }
                errorMsg.append(error.getDefaultMessage());
            }
            log.warn(errorMsg.toString());
            return result.fail(BaseCode.PARAM_ERROR.getCode(), errorMsg.toString());
        }
        //IllegalArgumentException
        if (e instanceof IllegalArgumentException) {
            log.info(e.getMessage());
            return result.fail(BaseCode.PARAM_ERROR.getCode(), e.getMessage());
        }
        //RuntimeException
        if(e instanceof RuntimeException) {
            log.error(e.getMessage(), e);
            String errorMsg = "java.sql.SQLException: Incorrect string value: '\\x";
            if(e.getMessage().contains(errorMsg)) {
                log.warn(e.getMessage());
                return result.fail(BaseCode.PARAM_ERROR.getCode(), "不支持的特殊字符");
            }
            return result.fail(BaseCode.SYSTEM_ERROR);
        }
        log.error("系统错误", e);
        return result.fail(BaseCode.SYSTEM_ERROR);
    }
}