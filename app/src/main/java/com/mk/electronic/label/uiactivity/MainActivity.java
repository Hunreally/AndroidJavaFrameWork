package com.mk.electronic.label.uiactivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mk.electronic.label.R;
import com.mk.electronic.label.mvp.model.MainModel;
import com.mk.electronic.label.mvp.presenter.MainPresenter;
import com.mk.electronic.label.mvp.view.MainView;
import com.mk.electronic.label.uiactivity.base.BaseActivity;
import com.mk.electronic.label.util.ImageLoadUtil;

import butterknife.BindView;
import butterknife.OnLongClick;

public class MainActivity extends BaseActivity<MainView,MainModel,MainPresenter> implements MainView {

    @BindView(R.id.hello)
    TextView mHello;
    @BindView(R.id.image)
    ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        ImageLoadUtil.getInstance().LoadImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&se" +
                "c=1532771784700&di=c28c01bb1d3f51b4f94cbb93c44aa887&imgtype=0&src=http%3A%2F%2Fh." +
                "hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F3c6d55fbb2fb43165a73bbab2ca4462308f7d3f7.jpg",imageView);
    }

    @Override
    public void loadDataFail(String msg) {
    }

    @OnLongClick(R.id.hello)
    public boolean OnViewLongClick(View view){
        return true;
    }
}
