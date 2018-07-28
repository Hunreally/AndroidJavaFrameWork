package com.framework.mvp.p;

import android.arch.lifecycle.Lifecycle;
import android.support.v7.app.AppCompatActivity;

import com.framework.mvp.m.BaseModel;
import com.framework.mvp.v.BaseView;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public abstract class BasePresenter<BView extends BaseView,BModel extends BaseModel>{

    public LifecycleProvider<Lifecycle.Event> mLifecycleProvider = null;
    private WeakReference<BView> mWeakView;
    private BView proxyView;
    protected BModel mModel;

    /**
     * 交给子类初始化Model
     * @return
     */
    protected abstract BModel initModel();

    /**
     * 用于检查View是否为空对象
     */
    public boolean isAttachView() {
        return this.mWeakView != null && this.mWeakView.get() != null;
    }

    /**
     * 构造函数初始化
     * @param view
     * @param activity
     */
    public BasePresenter(BView view, AppCompatActivity activity) {
        mModel=initModel();
        mLifecycleProvider = AndroidLifecycle.createLifecycleProvider(activity);
        this.mWeakView = new WeakReference<BView>(view);
        ViewInvocationHandler invocationHandler = new ViewInvocationHandler(this.mWeakView.get());
        proxyView = (BView) Proxy.newProxyInstance(
                view.getClass().getClassLoader(), view.getClass()
                        .getInterfaces(), invocationHandler);
        Proxy.getProxyClass(view.getClass().getClassLoader(),view.getClass().getInterfaces());
    }

    public BView getView() {
        return proxyView;
    }

    private class ViewInvocationHandler implements InvocationHandler {
        private BView view;
        public ViewInvocationHandler(BView view) {
            this.view = view;
        }
        @Override
        public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
            if (isAttachView()) {
                return method.invoke(view, arg2);
            }
            return null;
        }
    }

    /**
     * 销毁资源
     */
    public void dettachView() {
        if (this.mWeakView != null) {
            this.mWeakView.clear();
            this.mWeakView = null;
        }
    }

}
