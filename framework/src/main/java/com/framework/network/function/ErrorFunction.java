package com.framework.network.function;

import com.framework.network.exception.ExceptionHandle;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ErrorFunction <T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        return Observable.error(ExceptionHandle.handleException(throwable));
    }
}
