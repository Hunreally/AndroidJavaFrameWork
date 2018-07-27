package com.framework.network.function;

import com.framework.network.result.ResponseResult;

import io.reactivex.functions.Function;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ResponseFunction <T> implements Function<ResponseResult<T>, T> {
    @Override
    public T apply(ResponseResult<T> response) throws Exception {
        if (!response.isOk())
            throw new RuntimeException(response.getCode() + "=>" + response.getMsg() != null ? response.getMsg() : "");
        return response.getData();
    }
}
