package com.wj.exception;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class RabbitMqException extends RuntimeException{

    public RabbitMqException(String message) {
        super(message);
    }

    public RabbitMqException(String message, Throwable cause) {
        super(message, cause);
    }
}
