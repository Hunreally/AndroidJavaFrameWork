package com.framework.network.exception;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ResponeException extends Exception {
    public int code;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponeException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
