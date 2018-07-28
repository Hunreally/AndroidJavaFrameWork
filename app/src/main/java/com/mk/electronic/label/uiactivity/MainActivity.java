package com.mk.electronic.label.uiactivity;

import android.view.View;
import android.widget.TextView;

import com.mk.electronic.label.R;
import com.mk.electronic.label.mvp.model.MainModel;
import com.mk.electronic.label.mvp.presenter.MainPresenter;
import com.mk.electronic.label.mvp.view.MainView;
import com.mk.electronic.label.uiactivity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
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
    protected void onRxBindingViewLongClick(View view) {
    }

    @Override
    public void loadDataFail(String Msg) {
    }

    @OnClick(R.id.hello)
    public void OnViewClick(View view){
        setOnViewClick(view);
    }

    @OnLongClick(R.id.hello)
    public boolean OnViewLongClick(View view){
       setOnViewLongClick(view);
       return true;
    }
}
