package com.framework.mvp.m;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public abstract class BaseModel {

    public abstract <T> T loadData(Class<T> tClass);

}
