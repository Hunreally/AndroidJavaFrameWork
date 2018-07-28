package com.mk.electronic.label.app;

import com.framework.app.FrameWorkApp;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class MainAppication extends FrameWorkApp{

    public static MainAppication getAppAppication(){
        return (MainAppication) instance;
    }

    @Override
    public void onCreate() {
        instance=this;
        super.onCreate();
    }
}
