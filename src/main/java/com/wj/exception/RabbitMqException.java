package com.wj.exception;

import com.wj.enums.RegisterEnum;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class RabbitMqException extends RuntimeException{

    private RegisterEnum registerEnum;

    public RabbitMqException(RegisterEnum registerEnum) {
        super(registerEnum.getStateInfo());
        this.registerEnum = registerEnum;
    }

    public RegisterEnum getCodeMsg() {
        return registerEnum;
    }
}
