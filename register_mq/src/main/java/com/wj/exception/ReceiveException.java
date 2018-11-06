package com.wj.exception;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public class ReceiveException extends RabbitMqException {
    public ReceiveException(String message) {
        super(message);
    }

    public ReceiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
