package com.example.administrator.mvppractice.View;

import com.example.administrator.mvppractice.Bean.MainModelBean;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/1 16:18
 */

public interface MainView {
    //展示数据
    void showData(MainModelBean mainModelBean);
    String getData();
    void setShowData(String getShowData);
}
