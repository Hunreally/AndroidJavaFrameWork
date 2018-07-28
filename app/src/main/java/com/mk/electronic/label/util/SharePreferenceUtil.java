package com.mk.electronic.label.util;

import android.content.Context;

import com.framework.utils.FrameWorkSharePreferenceUtil;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public class SharePreferenceUtil extends FrameWorkSharePreferenceUtil{

    private SharePreferenceUtil(Context context) {
        super(context);
    }

    @Override
    public String getFileName() {
        return "appsp";
    }

    @Override
    public int getFileModel() {
        return Context.MODE_PRIVATE;
    }
}
