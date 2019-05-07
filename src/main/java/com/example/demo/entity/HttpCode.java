package com.example.demo.entity;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  18:08.
 * @Modified by:
 */
public enum HttpCode {
    OK(200),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    private int value;

     HttpCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
