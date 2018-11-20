package com.wj.amqp.producer.impl;


import com.wj.amqp.producer.MqProducer;
import com.wj.entity.User;
import com.wj.exception.RabbitMqException;
import com.wj.utils.CodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
@Service
public class Publisher implements MqProducer {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendDataToQueue(String exchangeKey, String queueKey, String messages) {
        //convertAndSend(String exchange, String routingKey, Object object), 将对象object封装成Message对象后, 发送给exchange
        amqpTemplate.convertAndSend(exchangeKey, queueKey, messages);
        System.out.println(" [" + queueKey + "] Sent :'" + messages + "'");
    }

}
