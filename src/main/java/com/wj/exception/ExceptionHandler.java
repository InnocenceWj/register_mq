package com.wj.exception;

import com.wj.enums.RegisterEnum;
import com.wj.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @创建人 wj
 * @创建时间 2018/11/20
 * @描述
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof ReceiveException) {
            ReceiveException ex = (ReceiveException) e;
            return Result.error(RegisterEnum.REVIEWCEIVE_FAIL);
        } else if (e instanceof SendException) {
            SendException ex = (SendException) e;
            return Result.error(ex.getCodeMsg());
        } else if (e instanceof RabbitMqException) {
            RabbitMqException ex = (RabbitMqException) e;
            return Result.error(ex.getCodeMsg());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(RegisterEnum.BIND_ERROR);
        } else {
            return Result.error(RegisterEnum.SERVER_ERROR);
        }
    }


}
