package com.framework.utils;

import android.util.Log;

import com.framework.BuildConfig;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class FrameWorkLogUtil {

    public static final String TAG="FrameWorkLogUtil";

    public static void Loge(String message){
        if (BuildConfig.DEBUG){
            Log.e(TAG,message);
        }
    }

    public static void loge(String message){
        if (BuildConfig.DEBUG){
            Log.e(TAG,message);
        }
    }

    public static void LogE(String tag,String message){
        if (BuildConfig.DEBUG){
            Log.e(tag,message);
        }
    }
}
