package com.framework.network.manager;

import com.framework.network.okhttp3.OkHttp3Creater;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Hunreally on 2018/7/26 0026.
 */
public class Retrofit2Manager {
    private Retrofit mRetrofit;

    protected  <T> T initRetrofit(String baseUrl,Class<T> tClass) {
        OkHttpClient.Builder builder = OkHttp3Creater.createNewOkHttp3();
        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return createRequest(tClass);
    }

    public <T> T createRequest(Class<T> tClass){
        return mRetrofit.create(tClass);
    }

}
