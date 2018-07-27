package com.framework.network.transformer;

import com.framework.network.function.ErrorFunction;
import com.framework.network.function.ResponseFunction;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class ErrorTransformer<T> implements ObservableTransformer {

    @Override
    public ObservableSource apply(Observable upstream) {
        return (Observable<T>) upstream.map(new ResponseFunction()).onErrorResumeNext(new ErrorFunction<T>());
    }
}