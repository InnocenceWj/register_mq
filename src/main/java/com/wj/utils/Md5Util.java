package com.wj.utils;

import org.springframework.util.DigestUtils;

/**
 * @创建人 wj
 * @创建时间 2018/10/26
 * @描述
 */
public class Md5Util {

    //    用于混淆的盐值
    private static String salt = "jhdgskdjbi938uhd";

    public static String getMd5Str(String uPhone,String uPwd){
        String base=uPhone+"/"+salt+"/"+uPwd;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
