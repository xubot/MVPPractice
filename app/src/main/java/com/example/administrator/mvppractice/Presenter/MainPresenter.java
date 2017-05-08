package com.example.administrator.mvppractice.Presenter;

import android.util.Log;

import com.example.administrator.mvppractice.Bean.MainModelBean;
import com.example.administrator.mvppractice.Model.MainModel;
import com.example.administrator.mvppractice.View.MainView;

import java.util.List;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/1 16:29
 */

public class  MainPresenter implements IMainPresenter{
    private MainView mainView;
    private MainModel mMainModel;

    public MainPresenter(MainView view) {
        this.mainView=view;
        mMainModel = new MainModel(this);
    }
    //分离view
   public void detachView() {
       this.mainView = null;
   }
   //得到值的方法
    public void loadData() {
        mMainModel.loadData();
    }
    //存值的方法
    public void  savaData(String getShowData) {
        mMainModel.cun(getShowData);
        if(getShowData!=null) {
            Log.d("zzz1", getShowData);
        }else {
            Log.d("zzz2", "无值");
        }
    }
    public void gettakeData(){
        List<String> list = mMainModel.takeData();
        mainView.setShowData(list.toString());
    }
    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {
        mainView.showData(mainModelBean);
    }

    @Override
    public void loadDataFailure() {

    }
}
