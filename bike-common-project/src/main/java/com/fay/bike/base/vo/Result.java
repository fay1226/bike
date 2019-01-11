package com.fay.bike.base.vo;

import com.fay.bike.base.enums.BaseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Result结果对象
 * @author fanqingfeng
 * @date 2018/10/31 15:41
 */
@Setter
@Getter
public class Result<T> {
    /**数据对象*/
    private T data;
    /**响应码*/
    private Integer code;
    /**是否成功*/
    private Boolean success;
    /**提示信息*/
    private String desMsg;

    public Result<T> success(T data) {
        this.data = data;
        this.success = true;
        this.code = BaseCode.SUCCESS.getCode();
        return this;
    }

    public Result<T> success(T data, String desMsg) {
        this.desMsg = desMsg;
        return success(data);
    }

    public Result<T> success(T data, Integer code, String desMsg) {
        this.code = code;
        this.data = data;
        this.success = true;
        this.desMsg = desMsg;
        return this;
    }

    public Result<T> success(T data, BaseCode baseCode) {
        this.data = data;
        this.code = baseCode.getCode();
        this.desMsg = baseCode.getMsg();
        this.success = true;
        return this;
    }

    public Result<T> fail(String desMsg) {
        this.success = false;
        this.desMsg = desMsg;
        this.code = BaseCode.FAIL.getCode();
        return this;
    }

    public Result<T> fail(T data, String desMsg) {
        this.data = data;
        return fail(desMsg);
    }

    public Result<T> fail(Integer code, String desMsg) {
        this.code = code;
        this.desMsg = desMsg;
        this.success = false;
        return this;
    }

    public Result<T> fail(T data, Integer code, String desMsg) {
        this.data = data;
        return fail(code, desMsg);
    }

    public Result<T> fail(BaseCode baseCode) {
        this.code = baseCode.getCode();
        this.desMsg = baseCode.getMsg();
        this.success = false;
        return this;
    }

    public Result<T> fail(T data, BaseCode baseCode) {
        this.data = data;
        return fail(baseCode);
    }
}