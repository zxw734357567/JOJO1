package com.example.demo.Exceptions;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  10:21.
 * @Modified by:
 */
public class ControllerValidateException extends RuntimeException {

    public ControllerValidateException(String message){
        super(message);
    }

}
