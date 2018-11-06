package com.wj.mapper;

import com.wj.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByCode(String uCode);

    void updateState(int i);

    User checkRepeatPhone(String phone);

    User checkRepeatMail(String mail);
}