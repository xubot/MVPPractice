package com.example.administrator.mvppractice.Presenter;

import com.example.administrator.mvppractice.Bean.MainModelBean;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/1 16:31
 */

public interface IMainPresenter {
    void loadDataSuccess(MainModelBean mainModelBean);
    void loadDataFailure();
}
