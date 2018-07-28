package com.framework.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public class FrameWorkToastUtil {

    public static void showShortToast(Context context,String Msg){
        Toast.makeText(context,Msg,Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context,String Msg){
        Toast.makeText(context,Msg,Toast.LENGTH_LONG).show();
    }
}
