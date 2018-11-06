package com.wj.amqp.listener;

import com.wj.utils.MailUtil;
import com.wj.utils.SendMsgUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @创建人 wj
 * @创建时间 2018/11/6
 * @描述
 */
public class MqMsgListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        String messageBody = null;
        try {
            messageBody = new String(message.getBody(),"utf-8");
            System.out.println(" [Msg] Received '" + messageBody + "'");
            String[] meassages=messageBody.split(",");
            new Thread(new SendMsgUtil(meassages[0],meassages[1])).start();
            System.out.println("发送短信中....");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
