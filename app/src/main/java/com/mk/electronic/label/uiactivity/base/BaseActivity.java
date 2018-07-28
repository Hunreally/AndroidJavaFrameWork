package com.mk.electronic.label.uiactivity.base;

import com.framework.activity.FrameWorkBaseActivity;
import com.framework.mvp.m.BaseModel;
import com.framework.mvp.p.BasePresenter;
import com.framework.mvp.v.BaseView;

/**
 * Created by Hunreally on 2018/7/28 0028.
 */
public abstract class BaseActivity
        <       BView extends BaseView,
                BModel extends BaseModel,
                BPresenter extends BasePresenter<BView,BModel>
        > extends FrameWorkBaseActivity<BView,BModel,BPresenter>  {

    @Override
    protected void initOnCreateBeforeSetContentView() {
    }
}
