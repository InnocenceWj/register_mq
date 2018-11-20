package com.wj.enums;

/**
 * @创建人 wj
 * @创建时间 2018/11/2
 * @描述
 */
public enum RegisterEnum{

    SEND_SUCCESS(101, "发送成功"),
    REVIEWCEIVE_SUCCESS(102, "接收成功"),
    SEND_FAIL(113, "发送失败"),
    REVIEWCEIVE_FAIL(114, "接收失败"),
    MQ_ERROR(115, "RabbitMq异常"),

    BIND_ERROR(210,"参数校验异常：%s!"),

    SERVER_ERROR(310, "系统异常");

    private int state;
    private String stateInfo;

    RegisterEnum(int state, String stateInfo) {
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
