package com.wj.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @创建人 wj
 * @创建时间 2018/11/5
 * @描述
 */
public class ConnectionUtil {
    private static final String host = "localhost";
    private static final int port = 5672;
    private static final String username="wj";
    private static final String password="123456";


    /**
     * 获取RabbitMQ Connection连接
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory.newConnection();
    }
}
