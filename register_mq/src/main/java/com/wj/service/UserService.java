package com.wj.service;

import com.wj.entity.User;

/**
 * @创建人 wj
 * @创建时间 2018/11/1
 * @描述
 */
public interface UserService {
     void registerUser(User user) throws Exception;

     User findUserByCode(String code);

     void updateState(User user);

     User checkRepeatPhone(String phone);

     User checkRepeatMail(String mail);
}
