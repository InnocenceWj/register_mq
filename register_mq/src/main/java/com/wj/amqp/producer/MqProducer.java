package com.wj.amqp.producer;

import com.wj.entity.User;

import java.io.UnsupportedEncodingException;

/**
 * @创建人 wj
 * @创建时间 2018/11/6
 * @描述
 */
public interface MqProducer {
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param str
     */
    void sendDataToQueue(String exchangeKey,String queueKey, String str) throws UnsupportedEncodingException;
}
