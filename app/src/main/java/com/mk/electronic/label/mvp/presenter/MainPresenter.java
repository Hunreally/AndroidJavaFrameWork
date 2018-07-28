package com.mk.electronic.label.mvp.presenter;

import android.support.v7.app.AppCompatActivity;

import com.framework.mvp.p.BasePresenter;
import com.mk.electronic.label.mvp.model.MainModel;
import com.mk.electronic.label.mvp.view.MainView;

/**
 * Created by Hunreally on 2018/7/27 0027.
 */
public class MainPresenter extends BasePresenter<MainView,MainModel> {

    @Override
    protected MainModel initModel() {
        return new MainModel();
    }

    public MainPresenter(MainView view, AppCompatActivity activity) {
        super(view, activity);
    }

    public void getModelData(){
        getView().loadDataFail(mModel.loadData(String.class));
    }

}
