package com.framework.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.framework.mvp.m.BaseModel;
import com.framework.mvp.p.BasePresenter;
import com.framework.mvp.v.BaseView;
import com.framework.utils.FrameWorkLogUtil;
import com.jakewharton.rxbinding2.view.RxView;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
//可使用其他方式搞定presenter
public abstract class FrameWorkBaseActivity
        <       BView extends BaseView,
                BModel extends BaseModel,
                BPresenter extends BasePresenter<BView,BModel>
        >extends AppCompatActivity {

    public BPresenter mPresenter;
    public CompositeDisposable mCompositeDisposable;
    private static final long nextClickTime=3;

    protected abstract int getLayoutId();
    protected abstract void initOnCreateBeforeSetContentView();
    protected abstract void initData();
    protected abstract void initView();
    protected abstract void onRxBindingViewClick(View view);
    protected abstract void onRxBindingViewLongClick(View view);




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///////////////////////////////////////////////////////////////////////////////////////////
        int layoutId=getLayoutId();
        if (layoutId>0){
            initOnCreateBeforeSetContentView();
            setContentView(layoutId);
            ButterKnife.bind(this);
        }else {
            throw new RuntimeException("not a layoutId by getLayoutId method return," +
                    "layoutId="+layoutId);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////
        initPresenter();
        initData();
        initView();
    }

    private void initPresenter() {
        ParameterizedType thisClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazzView = (Class) thisClass.getActualTypeArguments()[0];
        Class clazzPresenter = (Class) thisClass.getActualTypeArguments()[2];
        try {
            Constructor constructor = clazzPresenter.getConstructor(clazzView,AppCompatActivity.class);
            mPresenter= (BPresenter) constructor.newInstance(this,this);
        } catch (Exception e) {
            FrameWorkLogUtil.loge(e.toString());
            throw new RuntimeException("FrameWorkBaseActivity initPresenterClass Exception::" +
                    e.toString());
        }
    }

    public BPresenter getmPresenter() {
        return mPresenter;
    }



    public Disposable setOnViewClick(final View view){
        if (mCompositeDisposable==null){
            mCompositeDisposable=new CompositeDisposable();
        }
        Disposable disposable= RxView.clicks(view).throttleFirst(nextClickTime, TimeUnit.SECONDS).subscribe(new Consumer<Object>() {

            @Override
            public void accept(Object o) throws Exception {
                onRxBindingViewClick(view);
            }
        });
        mCompositeDisposable.add(disposable);
        return disposable;
    }

    public Disposable setOnViewLongClick(final View view){
        if (mCompositeDisposable==null){
            mCompositeDisposable=new CompositeDisposable();
        }
        Disposable disposable= RxView.longClicks(view).throttleFirst(nextClickTime, TimeUnit.SECONDS).subscribe(new Consumer<Object>() {

            @Override
            public void accept(Object o) throws Exception {
                onRxBindingViewLongClick(view);
            }
        });
        mCompositeDisposable.add(disposable);
        return disposable;
    }

    @Override
    protected void onDestroy() {
        if (mPresenter!=null){
            mPresenter.dettachView();
        }
        if (mCompositeDisposable!=null){
            mCompositeDisposable.clear();
        }
        super.onDestroy();
    }

}
