package com.mk.electronic.label.net;

import com.framework.network.result.ResponseResult;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public interface RequestAPIOne {

    @POST("/blog")
    Observable<ResponseResult<String>> getBlogs();

}
