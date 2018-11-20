package com.wj.amqp.listener;

import com.wj.utils.MailUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


/**
 * @创建人 wj
 * @创建时间 2018/11/6
 * @描述
 */
public class MqMailListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String messageBody = null;
        try {
            messageBody = new String(message.getBody(),"utf-8");
            System.out.println(" [mail] Received '" + messageBody + "'");
            String[] meassages=messageBody.split(",");
            new Thread(new MailUtil(meassages[0],meassages[1])).start();
            System.out.println("发送邮件中....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
