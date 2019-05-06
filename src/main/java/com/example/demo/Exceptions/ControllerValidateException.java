package com.example.demo.Exceptions;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  10:21.
 * @Modified by:
 */
public class ControllerValidateException extends RuntimeException {
   private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
