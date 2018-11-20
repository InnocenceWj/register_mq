package com.wj.exception;


import com.wj.enums.RegisterEnum;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class ReceiveException extends RabbitMqException {
    private RegisterEnum registerEnum;

    public ReceiveException(RegisterEnum registerEnum) {
        super(registerEnum);
        this.registerEnum = registerEnum;
    }

}
