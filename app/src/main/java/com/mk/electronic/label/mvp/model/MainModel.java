package com.mk.electronic.label.mvp.model;

import com.framework.mvp.m.BaseModel;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class MainModel extends BaseModel {

    @Override
    public <T> T loadData(Class<T> tClass) {
        return (T) "model return";
    }



}
