package com.framework.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.framework.utils.FrameWorkSharePreferenceUtil;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class FrameWorkApp extends Application{

    public static FrameWorkApp instance=null;

    public static Application getApp(){
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        FrameWorkSharePreferenceUtil.getInstance(this);
    }
}
