package com.wj.utils;
/**
 * 生成随机字符串工具类
 */

import java.util.UUID;

public class CodeUtil {
    //生成唯一的激活码
    public static String generateUniqueCode() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateMsgCode() {
        int num = (int) ((Math.random() * 9 + 1) * 100000);//6位数验证码
        String code = num + "";
        return code;
    }
}
