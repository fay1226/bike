package com.fay.bike.app.enums;

/**
 * BaseCode
 * @author fanqingfeng
 * @date 2018/10/31 15:41
 */
public enum BaseCode {
    /**特殊处理*/
    STATUS_SPEC(11111, "特殊处理"),
    /**操作成功*/
    SUCCESS(10000, "操作成功"),
    /**操作失败*/
    FAIL(10001, "操作失败"),
    /**登录失败*/
    LOGIN_FAIL(10002, "登录失败"),
    /**授权失败*/
    AUTH_FAIL(10003, "授权失败"),
    /**权限不足*/
    NO_AUTHENTION(10005, "权限不足"),
    /**请求太频繁*/
    FREQUENTLY(-1900, "请求太频繁"),
    /**参数错误*/
    PARAM_ERROR(-1998, "参数错误"),
    /**状态异常*/
    STATUS_FAIL(-1999, "状态异常");


    private Integer code;
    private String msg;

    BaseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
