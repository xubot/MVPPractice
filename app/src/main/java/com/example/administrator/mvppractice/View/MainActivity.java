package com.example.administrator.mvppractice.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mvppractice.Bean.MainModelBean;
import com.example.administrator.mvppractice.Presenter.MainPresenter;
import com.example.administrator.mvppractice.R;

public class MainActivity extends AppCompatActivity implements MainView{

    private TextView text;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        text = (TextView) findViewById(R.id.text);
        mMainPresenter = new MainPresenter(this);
        //得到Presenter层的值的方法
        mMainPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showData(MainModelBean mainModelBean) {
        String showData = getResources().getString(R.string.city) + mainModelBean.getCity()
                + getResources().getString(R.string.wd) + mainModelBean.getWd()
                + getResources().getString(R.string.ws) + mainModelBean.getWs()
                + getResources().getString(R.string.time) + mainModelBean.getTime();
        text.setText(showData);
    }
}
