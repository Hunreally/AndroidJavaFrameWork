package com.framework.network;

import com.framework.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Hunreally on 2018/7/26 0026.
 */
public class OkHttp3Creater {

    //超时时间30秒
    private static long DEFAULT_TIMEOUT=30;

    /*
     * 创建okhttp的构建者以及设置okhttp参数
     */
    public static OkHttpClient.Builder createOkHttp3(){
        OkHttpClient.Builder okHttpClientBuilder=null;
        okHttpClientBuilder=new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor LoginInterceptor = new HttpLoggingInterceptor();
            LoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(LoginInterceptor); //添加retrofit日志打印
        }
        //连接超时
        okHttpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //读数据超时
        okHttpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //写数据超时
        okHttpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        //连接失败重试
//        okHttpClientBuilder.retryOnConnectionFailure(true);
        return okHttpClientBuilder;
    }






}
