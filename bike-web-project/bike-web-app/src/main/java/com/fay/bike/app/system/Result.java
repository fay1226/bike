package com.fay.bike.app.system;

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
        return success(data, BaseCode.SUCCESS);
    }

    public Result<T> success(T data, BaseCode code) {
        return success(data, code, null);
    }

    public Result<T> success(T data, BaseCode code, String desMsg) {
        this.code = code.getCode();
        this.success = true;
        this.data = data;
        this.desMsg = desMsg;
        return this;
    }

    public Result<T> fail(String desMsg) {
        return fail(BaseCode.FAIL, desMsg);
    }

    public Result<T> fail(BaseCode code, String desMsg) {
        return fail(null, code, desMsg);
    }

    public Result<T> fail(T data, BaseCode code, String desMsg) {
        this.code = code.getCode();
        this.success = false;
        this.data = data;
        this.desMsg = desMsg;
        return this;
    }
}
