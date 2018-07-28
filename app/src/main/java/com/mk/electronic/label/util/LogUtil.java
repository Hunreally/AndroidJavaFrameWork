package com.mk.electronic.label.util;

import com.framework.utils.FrameWorkLogUtil;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public class LogUtil {

    private static final String TAG="LogUtil";

    public static void Loge(String message){
        FrameWorkLogUtil.LogE(TAG,message);
    }

    public static void loge(String message){
        FrameWorkLogUtil.LogE(TAG,message);
    }

}
