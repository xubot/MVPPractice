package com.example.administrator.mvppractice.Model;


import com.example.administrator.mvppractice.Bean.MainModelBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface Model {
    void loadData();
    void cun(String getShowData);
    List<String> takeData();
}
