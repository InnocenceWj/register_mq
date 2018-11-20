package com.wj.result;

import com.wj.enums.RegisterEnum;
import lombok.Data;

/**
 * @创建人 wj
 * @创建时间 2018/11/20
 * @描述
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(RegisterEnum registerEnum) {
        if (registerEnum == null) {
            return;
        }
        this.code = registerEnum.getState();
        this.msg = registerEnum.getStateInfo();
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(RegisterEnum codeMsg) {
        return new Result<T>(codeMsg);
    }
}
