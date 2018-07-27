package com.framework.network.result;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ResponseResult<T> {
    private static final int OKCODE=0;
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return code ==OKCODE;
    }
}
