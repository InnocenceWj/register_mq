package com.wj.service.impl;

import com.wj.amqp.producer.MqProducer;
import com.wj.constmq.Const;
import com.wj.entity.User;
import com.wj.mapper.UserMapper;
import com.wj.utils.CodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.wj.service.UserService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;


/**
 * @创建人 wj
 * @创建时间 2018/11/1
 * @描述
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;
    @Resource
    private MqProducer mqProducer;

    @Override
    public void registerUser(User user) {

        int i = userMapper.insertSelective(user);
        if (i > 0) {
            String mailMessage=new String(user.getUMail() +","+ user.getUCode());
            String msgMessage=new String(user.getUPhone()+","+ CodeUtil.generateMsgCode());
            try {
                mqProducer.sendDataToQueue(Const.EXCHANGE_NAME_MAIL,Const.QUEUE_NAME_MAIL,mailMessage);
                mqProducer.sendDataToQueue(Const.EXCHANGE_NAME_PHONE,Const.QUEUE_NAME_PHONE,msgMessage);
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }

    @Override
    public User findUserByCode(String code) {
        User user = userMapper.findUserByCode(code);
        return user;
    }

    @Override
    public void updateState(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User checkRepeatPhone(String phone) {
        User user = userMapper.checkRepeatPhone(phone);
        return user;
    }

    @Override
    public User checkRepeatMail(String mail) {
        User user = userMapper.checkRepeatMail(mail);
        return user;
    }


}
