package com.mk.electronic.label.uiactivity;

import android.widget.TextView;

import com.mk.electronic.label.R;
import com.mk.electronic.label.mvp.model.MainModel;
import com.mk.electronic.label.mvp.presenter.MainPresenter;
import com.mk.electronic.label.mvp.view.MainView;
import com.mk.electronic.label.uiactivity.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainView,MainModel,MainPresenter> implements MainView {

    @BindView(R.id.hello)
    TextView mHello;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
//        Retrofit2One.getInstance().getBlogs();
    }

    @Override
    protected void initView() {
        mHello.setText("666"+mPresenter.getModelData());
    }

    @Override
    public void loadDataFail(String Msg) {
    }
}
