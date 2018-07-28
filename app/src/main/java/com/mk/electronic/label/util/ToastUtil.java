package com.mk.electronic.label.util;

import com.framework.utils.FrameWorkToastUtil;
import com.mk.electronic.label.app.MainAppication;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public class ToastUtil {

    public static void showShortToast(String Msg){
        FrameWorkToastUtil.showShortToast(MainAppication.getApp(),Msg);
    }

    public static void showLongToast(String Msg){
        FrameWorkToastUtil.showLongToast(MainAppication.getApp(),Msg);
    }
}
