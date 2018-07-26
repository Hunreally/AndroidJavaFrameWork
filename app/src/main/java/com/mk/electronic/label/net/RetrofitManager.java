package com.mk.electronic.label.net;

import com.framework.network.OkHttp3Creater;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hunreally on 2018/7/26 0026.
 */
public class RetrofitManager {

    String BASE_URL="";

    private static RetrofitManager mRetrofitManager;
    private Retrofit mRetrofit;

    private RetrofitManager(){
        initRetrofit();
    }

    public static synchronized RetrofitManager getInstance(){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitManager();
        }
        return mRetrofitManager;
    }


    private void initRetrofit() {
        OkHttpClient.Builder builder = OkHttp3Creater.createOkHttp3();
        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public <T> T createRequest(Class<T> requestServer){
        return mRetrofit.create(requestServer);
    }

}
