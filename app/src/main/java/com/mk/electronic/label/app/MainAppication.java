package com.mk.electronic.label.app;

import com.framework.app.FrameWorkApp;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class MainAppication extends FrameWorkApp{

    private static MainAppication mainAppication=null;

    public static MainAppication getApp(){
        return mainAppication;
    }

    @Override
    public void onCreate() {
        mainAppication=this;
        super.onCreate();
    }
}
