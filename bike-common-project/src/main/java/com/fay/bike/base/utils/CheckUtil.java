package com.fay.bike.base.utils;

import com.fay.bike.base.enums.RegexEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数验证工具类
 *
 * @author fanqingfeng
 * @date 2018/11/2 11:22
 */
public class CheckUtil {
    private CheckUtil() {}

    /**
     * 验证手机号格式
     */
    public static void checkPhone(String phone) {
        checkPhone(phone, RegexEnum.PHONE.getRegex());
    }

    /**
     * 验证手机号格式，指定正则
     */
    public static void checkPhone(String phone, String regex) {
        if (StringUtil.isEmpty(phone)) {
            throw new IllegalArgumentException("手机号不能为空");
        }
        int length = 11;
        if (phone.trim().length() != length) {
            throw new IllegalArgumentException("手机号码应为11位数");
        }
        checkByRegex(phone, regex, "手机号格式不正确");
    }

    /**
     * 判断是否符合正则表达式
     */
    public static void checkByRegex(String value, String regex, String errorMsg) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

}
