package com.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public class FrameWorkSharePreferenceUtil {

    public String getFileName(){
        return "SPF";
    };
    public int getFileModel(){
        return Context.MODE_PRIVATE;
    };

    private static SharedPreferences sharedPreferences=null;

    private static FrameWorkSharePreferenceUtil instance;

    protected FrameWorkSharePreferenceUtil(Context context){
        if (sharedPreferences!=null){
            sharedPreferences=null;
        }
        sharedPreferences =context.getSharedPreferences(getFileName(),getFileModel());
    }

    public static synchronized FrameWorkSharePreferenceUtil getInstance(Context context){
        if (instance==null){
            synchronized (FrameWorkSharePreferenceUtil.class){
                if (instance==null){
                    instance=new FrameWorkSharePreferenceUtil(context);
                }
            }
        }
        return instance;
    }

    public static void setBoolean(String key, Boolean value) {
        if (value != sharedPreferences.getBoolean(key, false)) {
            Editor editor = sharedPreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public static boolean getBoolean(String key, Boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void setString(String key, String value) {
        if (!sharedPreferences.getString(key, "").equals(value)) {
            Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public static void setLong(String key, Long value) {
        if (value != sharedPreferences.getLong(key, 0xFF)) {
            Editor editor = sharedPreferences.edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public static long getLong(String key, Long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static void setInt(String key, int value) {
        if (value != sharedPreferences.getInt(key, 0xFF)) {
            Editor editor = sharedPreferences.edit();
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public static int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
}
