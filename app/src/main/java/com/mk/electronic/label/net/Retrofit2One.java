package com.mk.electronic.label.net;

import com.framework.network.transformer.ErrorTransformer;
import com.framework.network.transformer.UiThreadSchedulersTransformer;
import com.framework.network.result.ResponseResult;
import com.mk.electronic.label.net.base.Retrofit2Manager;

import io.reactivex.Observable;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class Retrofit2One extends Retrofit2Manager{

    private String BASE_URL="";

    private static Retrofit2One mRetrofit2One;
    private RequestAPIOne mRequestAPIOne=null;

    private Retrofit2One(){
        mRequestAPIOne=initRetrofit(BASE_URL,RequestAPIOne.class);
    }

    public static synchronized Retrofit2One getInstance(){
        if (mRetrofit2One == null){
            mRetrofit2One = new Retrofit2One();
        }
        return mRetrofit2One;
    }

    public Observable<ResponseResult<String>> getBlogs(){
        return mRequestAPIOne
                .getBlogs()
                .compose(new UiThreadSchedulersTransformer())
                .compose(new ErrorTransformer<ResponseResult<String>>());
    }




}
