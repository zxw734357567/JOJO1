package com.example.demo.entity;

import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

import java.util.Map;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  13:24.
 * @Modified by:
 */
public class ResultEntity<T> {
    private final  int code;

    private final String message;

    private final  T data;

    private final Map<String, Object> extraInfo;

    public ResultEntity(int code, @Nullable String message, @Nullable T value , @Nullable Map<String, Object> extraInfo) {
        this.code= code;
        this. message=message;
        this.data=value;
        this.extraInfo=extraInfo;
    }

    public ResultEntity( int code, @Nullable String message, @Nullable T value) {
        this(code,message,value,(Map<String, Object>) null);
    }

    public ResultEntity( int code, @NonNull T value) {
        this(code,(String)null,value,(Map<String, Object>) null);
    }

    public ResultEntity( int code,  String message) {
        this(code,message,(T)null,(Map<String, Object>) null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }
}
