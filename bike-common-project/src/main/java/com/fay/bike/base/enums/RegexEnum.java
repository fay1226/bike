package com.fay.bike.base.enums;

/**
 * @author fanqingfeng
 * @date 2018/11/5 16:43
 */
public enum RegexEnum {
    /**手机号正则*/
    PHONE("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$"),
    /**车牌号正则*/
    CAR_NUMBER("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$");

    private String regex;

    RegexEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
