package com.fay.bike.base.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String工具类
 * @author fanqingfeng
 * @date 2018/11/1 11:59
 */
@Slf4j
public class StringUtil {
    private StringUtil() {}

    private static final String CHAR_CODE = "UTF-8";
    private static final String LOG_TAG = "e = {}";

    /**url编码，默认编码utf-8*/
    public static String urlEncode(String str) {
        return urlEncode(str, CHAR_CODE);
    }

    /**url编码*/
    public static String urlEncode(String str, String charsetName) {
        if (isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, charsetName);
        } catch (UnsupportedEncodingException e) {
            log.info(LOG_TAG, e);
        }
        return "";
    }

    /**url解码，默认编码utf-8*/
    public static String urlDecode(String str) {
        return urlDecode(str, CHAR_CODE);
    }

    /**url解码*/
    public static String urlDecode(String str, String charsetName) {
        if (isEmpty(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, charsetName);
        } catch (UnsupportedEncodingException e) {
            log.info(LOG_TAG, e);
        }
        return "";
    }

    /**
     * 转换为脚本字符串
     */
    public static String toScriptStr(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return str.replace("\\", "\\\\").replace("\n", "\\n").replace("\"", "\\\"").replaceAll("\t", " ")
                .replaceAll("  ", " ").replace("\r", " ");
    }

    /**超过指定长度超过部分以mark内容结束**/
    public static String showShort(String content, int length, String mark) {
        if (content == null || content.length() <= length) {
            return content;
        }
        if (mark == null || mark.length() > length) {
            mark = "";
        }
        byte[] source = content.getBytes();
        int temp = 0;
        for (int i = 0; i < length; ++i) {
            if (source[i] < 0) {
                temp += 3;
            } else {
                ++temp;
            }
        }
        int showLen = temp + mark.length();
        byte[] res = new byte[showLen];
        System.arraycopy(source, 0, res, 0, showLen);
        return new String(res) + mark;
    }

    /**超过指定长度以...结束**/
    public static String showShort(String content, int length) {
        return showShort(content, length, "...");
    }

    /**
     * MD5加密字符串
     */
    public static String getMD5(String str) {
        if (isEmpty(str)) {
            return "";
        }
        StringBuilder hex = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] hash = md5.digest();

            for (byte b : hash) {
                if ((255 & b) < 16) {
                    hex.append(0).append(Integer.toHexString(255 & b));
                } else {
                    hex.append(Integer.toHexString(255 & b));
                }
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            log.info(LOG_TAG, e);
        }
        return "";
    }

    /**
     * 16位MD5
     */
    public static String get16Md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] b = md5.digest();
            StringBuilder buf = new StringBuilder();

            for (int i : b) {
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            log.info(LOG_TAG, e);
        }
        return "";
    }

    /**
     * 添加参数前转换url
     */
    public static String setSafeUrl(String url) {
        char mark = '?';
        if (url.indexOf(mark) >= 0) {
            return url + "&";
        }
        return url + "?";
    }

    /**
     * 替换字符串中的不安全字符
     */
    public static String toSafeStr(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll("\"", "＂").replaceAll("'", "＇").replaceAll("\t", " ").replaceAll("  ", "").
                replaceAll("\r", " ").replaceAll("\n", "\\n");
    }

    /**
     * 字符串null处理为""
     */
    public static String delNullStr(String str) {
        return str == null ? "" : str;
    }

    /**
     * 将utf-8编码转换为gbk
     */
    public static String utf2gbk(String str) {
        return exchangeCharCode(str, "utf-8", "gbk");
    }

    /**
     * 将gbk编码转换为utf-8
     */
    public static String gbk2utf(String str) {
        return exchangeCharCode(str, "gbk", "utf-8");
    }

    /**
     * 将将已知编码转换为指定编码
     */
    public static String exchangeCharCode(String str, String oldCode, String newCode) {
        String tmp = "";
        try {
            tmp = new String(str.getBytes(oldCode), newCode);
        } catch (UnsupportedEncodingException e) {
            log.info(LOG_TAG, e);
        }
        return tmp;
    }

    /**
     * 字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.length() == 0;
    }

    /**
     * 字符串是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 比较两个字符串内容是否相同
     */
    public static boolean isEquals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }
        return str1.equals(str2);
    }

    /**
     * 字符串是否在字符串数组中
     */
    public static boolean isEqualsIn(String str, String[] sourceArray) {
        if (isEmpty(str) || sourceArray == null || sourceArray.length == 0) {
            return false;
        }
        for (String source : sourceArray) {
            if (isEquals(str, source)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否以某字符串结尾
     */
    public static boolean endsWithIgnoreCase(String beChecked, String str) {
        if (beChecked == null || str == null) {
            return false;
        }
        return beChecked.toUpperCase().endsWith(str.toUpperCase());
    }

    public static char[] bytesToChars(byte[] bytes, int offset, int length) {
        String s = new String(bytes, offset, length);
        return s.toCharArray();
    }

    public static String findStr(String source, String start, String end) {
        if (source == null) {
            return null;
        }
        int i;
        if (isNotEmpty(start)) {
            i = source.indexOf(start);
            if (i < 0) {
                return null;
            }
            source = source.substring(i + start.length());
        }

        if (isNotEmpty(end)) {
            i = source.indexOf(end);
            if (i < 0) {
                return null;
            }
            source = source.substring(0, i);
        }
        return source;
    }

    public static String getIndexString(int index, int length) {
        StringBuilder sDatesBefore = new StringBuilder(String.valueOf(index));
        while (sDatesBefore.length() < length) {
            sDatesBefore.append("0");
        }
        return sDatesBefore.toString();
    }

    public static String getIndexPath(int index, int length) {
        StringBuilder tmp = new StringBuilder();
        String idStr = getIndexString(index, length);
        int mit = 2;
        for (int i = 0; i < idStr.length(); i += mit) {
            String s = idStr.substring(i, i + 2);
            tmp.append('/').append(s);
        }
        return tmp.toString();
    }

    /**
     * 转码为html
     */
    public static String toSafeHtml(String content) {
        content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        content = replaceMatcher(content, "((?:(?:http|ftp|https):\\/\\/){0,1}(?:(?:\\w|\\d)+\\.)+(?:\\S+))", "<a href=\"$1\">$1</a>");
        return content.replaceAll(" ", "&nbsp;").replaceAll("\n", "<br/>");
    }

    /**
     * 不区分大小写字符替换
     */
    public static String replaceMatcher(String str, String regex, String toStr) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        StringBuffer buf = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buf, toStr);
        }

        matcher.appendTail(buf);
        return buf.toString();
    }

    /**
     * html转码
     */
    public static String htmlEncode(String source) {
        if (source == null) {
            return "";
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < source.length(); ++i) {
            char c = source.charAt(i);
            switch (c) {
                case '\n':
                case '\r':
                    break;
                case '"':
                    b.append("&quot;");
                    break;
                case '&':
                    b.append("&amp;");
                    break;
                case '<':
                    b.append("&lt;");
                    break;
                case '>':
                    b.append("&gt;");
                    break;
                case '`':
                    b.append("'");
                    break;
                default:
                    b.append(c);
            }
        }
        return b.toString();
    }

    /**
     * 获取邮箱后缀
     */
    public static String getEmailExt(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    /**
     * 获取邮箱前缀
     */
    public static String getEmailName(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    /**
     * 首字母大写
     */
    public static String firstLowerCase(String str) {
        return str == null ? null : str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 去首尾空格
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 去除所有空格
     */
    public static String trimAll(String str) {
        return str == null ? null : str.replaceAll(" ", "");
    }

    /**
     * 是否为url
     */
    public static boolean isUrl(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException e) {
            log.info(LOG_TAG, e);
        }
        return false;
    }

}
