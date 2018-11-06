package com.wj.controller;

import com.wj.entity.User;
import com.wj.enums.RabbitMqEnum;
import com.wj.exception.RabbitMqException;
import com.wj.exception.ReceiveException;
import com.wj.exception.SendException;
import com.wj.service.UserService;
import com.wj.utils.CodeUtil;
import com.wj.utils.MailUtil;
import com.wj.utils.Md5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @创建人 wj
 * @创建时间 2018/11/1
 * @描述 遇到了一个问题：不同包使用类变红色，因为com.wj 是后加的package，所以，package有问题
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/registerUser")
    public String registerUser(User user) {
        Date date = new Date();
        user.setuPwd(Md5Util.getMd5Str(user.getuPhone(), user.getuPwd()));
        user.setuCode(CodeUtil.generateUniqueCode());
        user.setuCreateTime(date);
        try {
            userService.registerUser(user);
        } catch (SendException e) {
            System.out.println(RabbitMqEnum.SEND_FAIL);
        } catch (ReceiveException e) {
            System.out.println(RabbitMqEnum.REVIEWCEIVE_FAIL);
        }catch (RabbitMqException e){
            System.out.println(RabbitMqEnum.MQ_ERROR);
        } catch (Exception e) {
            System.out.println(RabbitMqEnum.MQ_ERROR);
        }
        return "registerSuccess";
    }

    @RequestMapping(value = "/checkRepeatPhone")
    @ResponseBody
    public User checkRepeatPhone(String phone) {
        return userService.checkRepeatPhone(phone);
    }

    @RequestMapping(value = "/checkRepeatMail")
    @ResponseBody
    public User checkRepeatMail(String mail) {
        return userService.checkRepeatMail(mail);
    }

    @RequestMapping(value = "/activeUser")
    public String activeUser(String code) {
        if (code != "") {
            User user = userService.findUserByCode(code);
            if (user != null) {
                user.setuState(true);
                userService.updateState(user);
            }
        }
        return "activeSuccess";
    }

}
