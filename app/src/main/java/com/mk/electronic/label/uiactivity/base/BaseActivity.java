package com.mk.electronic.label.uiactivity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.framework.activity.FrameWorkBaseActivity;
import com.framework.mvp.m.BaseModel;
import com.framework.mvp.p.BasePresenter;
import com.framework.mvp.v.BaseView;
import com.mk.electronic.label.app.MainAppication;
import com.mk.electronic.label.util.SharePreferenceUtil;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public abstract class BaseActivity
        <       BView extends BaseView,
                BModel extends BaseModel,
                BPresenter extends BasePresenter<BView,BModel>
        > extends FrameWorkBaseActivity<BView,BModel,BPresenter>  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharePreferenceUtil.getInstance(MainAppication.getAppAppication());
    }

    @Override
    protected void initOnCreateBeforeSetContentView() {
    }

    @Override
    protected void onRxBindingViewClick(View view) {

    }

    @Override
    protected void onRxBindingViewLongClick(View view) {

    }
}
