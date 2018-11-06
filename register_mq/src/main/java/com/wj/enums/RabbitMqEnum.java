package com.wj.enums;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public enum RabbitMqEnum {

    SEND_SUCCESS(1, "发送成功"),
    REVIEWCEIVE_SUCCESS(2, "接收成功"),
    SEND_FAIL(-1, "发送失败"),
    REVIEWCEIVE_FAIL(-2, "接收失败"),
    MQ_ERROR(-3, "RabbitMq异常");

    private int state;
    private String stateInfo;

    RabbitMqEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
