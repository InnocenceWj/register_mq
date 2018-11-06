package com.wj.exception;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class SendException extends RabbitMqException {

    public SendException(String message) {
        super(message);
    }

    public SendException(String message, Throwable cause) {
        super(message, cause);
    }
}
