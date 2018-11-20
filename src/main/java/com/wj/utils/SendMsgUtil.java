package com.wj.utils;


import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class SendMsgUtil implements Runnable{

    private String phone;//收信人
    private String code;//验证码

    public SendMsgUtil(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    @Override
    public void run() {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); //sms平台接口
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置编码集格式

        NameValuePair[] data = {
                new NameValuePair("Uid", "用户名"),//sms平台的用户名
                new NameValuePair("Key", "短信秘钥"),//短信秘钥，不是密码
                new NameValuePair("smsMob", phone),//目的手机号码，多个手机号用半角逗号隔开
                new NameValuePair("smsText", "本次验证码为:" + code + "" + "，有效时间为5分钟")//短信内容，自定义
        };
        post.setRequestBody(data);

        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //打印状态码和响应头信息
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        Header[] headers = post.getResponseHeaders();
        for (Header h : headers) {
            System.out.println(h.toString());
        }

        String result = null;
        try {
            result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("信息状态："+result); //打印返回的消息状态
        post.releaseConnection();
    }
}
