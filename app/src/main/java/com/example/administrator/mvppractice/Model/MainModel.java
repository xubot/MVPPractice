package com.example.administrator.mvppractice.Model;

import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mvppractice.Bean.MainModelBean;
import com.example.administrator.mvppractice.Presenter.IMainPresenter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/1 16:36
 */

public class MainModel implements Model {
    private IMainPresenter iMainPresenter;
    private MainModelBean mainModelBean;
    private List<String> dataList=new ArrayList<>();

    public MainModel(IMainPresenter iMainPresenter) {
        this.iMainPresenter = iMainPresenter;
    }
    //得到值的地方
    @Override
    public void loadData() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    mainModelBean = new MainModelBean();
                    JSONObject weatherinfo = response.getJSONObject("weatherinfo");
                    mainModelBean.setCity(weatherinfo.getString("city"));
                    mainModelBean.setWd(weatherinfo.getString("WD"));
                    mainModelBean.setWs(weatherinfo.getString("WS"));
                    mainModelBean.setTime(weatherinfo.getString("time"));
                    iMainPresenter.loadDataSuccess(mainModelBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                iMainPresenter.loadDataFailure();
            }
        });
    }
    //存入集合的方法
    @Override
    public void cun(String getShowData) {
        dataList.add(getShowData);
        Log.d("zzz", dataList.toString());
    }

    //取出值的方法
    @Override
    public List<String> takeData() {
        return dataList;
    }
}
