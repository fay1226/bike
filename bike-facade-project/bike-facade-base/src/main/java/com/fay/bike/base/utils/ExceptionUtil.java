package com.fay.bike.base.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;

/**
 * 异常工具类
 * @author fanqingfeng
 * @date 2018/11/1 10:28
 */
public class ExceptionUtil {
    private ExceptionUtil() {}

    public static String getMessage(Exception e) {
        StringWriter out = new StringWriter();
        e.printStackTrace(new PrintWriter(out));
        return out.toString();
    }

    public static void logMessage(Exception e, Logger logger) {
        StringWriter out = new StringWriter();
        e.printStackTrace(new PrintWriter(out));
        logger.error("{}", out);
    }
}
