package com.example.demo.Exceptions.ExceptionHandler;

import com.example.demo.Exceptions.ControllerValidateException;
import com.example.demo.entity.HttpCode;
import com.example.demo.entity.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/7  13:30.
 * @Modified by:
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(ControllerValidateException.class)
    public ResultEntity handlerControllerValidateException(ControllerValidateException exception) {
        return new ResultEntity(HttpCode.INTERNAL_SERVER_ERROR, exception.getMessage());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultEntity handlerControllerValidateException(RuntimeException exception) {
        //可以在这个上面,将异常给统计出来,存入到表中,可以获取更多的信息,从Exception
        exception.printStackTrace();
        return new ResultEntity(HttpCode.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
