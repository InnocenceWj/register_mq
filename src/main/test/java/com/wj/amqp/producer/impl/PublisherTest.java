package com.wj.amqp.producer.impl;

import com.wj.amqp.producer.MqProducer;
import com.wj.constmq.Const;
import com.wj.entity.User;
import com.wj.utils.CodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @创建人 wj
 * @创建时间 2018/11/6
 * @描述
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-rabbitmq.xml"})
public class PublisherTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MqProducer mqProducer;

    @Test
    public void sendDataToQueue() throws Exception {
        User user=new User();
        user.setUMail("1575391948@qq.com");
        user.setUCode(CodeUtil.generateUniqueCode());
        user.setUPhone("12612351235");
        String phoneMessage=new String(user.getUPhone()+","+ CodeUtil.generateMsgCode());
        String mailMessage=new String(user.getUMail()+","+user.getUCode());
//        mqProducer.sendDataToQueue(Const.EXCHANGE_NAME_MAIL,Const.QUEUE_NAME_MAIL,phoneMessage);
        mqProducer.sendDataToQueue(Const.EXCHANGE_NAME_PHONE,Const.QUEUE_NAME_PHONE,phoneMessage);
    }
}