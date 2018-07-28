package com.mk.electronic.label.uiactivity;

import android.view.View;
import android.widget.TextView;

import com.mk.electronic.label.R;
import com.mk.electronic.label.mvp.model.MainModel;
import com.mk.electronic.label.mvp.presenter.MainPresenter;
import com.mk.electronic.label.mvp.view.MainView;
import com.mk.electronic.label.uiactivity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnLongClick;

public class MainActivity extends BaseActivity<MainView,MainModel,MainPresenter> implements MainView {

    @BindView(R.id.hello)
    TextView mHello;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
    }

    @Override
    public void loadDataFail(String msg) {
    }

    @OnLongClick(R.id.hello)
    public boolean OnViewLongClick(View view){
        return true;
    }
}
