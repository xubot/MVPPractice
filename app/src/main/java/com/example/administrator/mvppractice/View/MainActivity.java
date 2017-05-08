package com.example.administrator.mvppractice.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mvppractice.Bean.MainModelBean;
import com.example.administrator.mvppractice.Presenter.MainPresenter;
import com.example.administrator.mvppractice.R;

public class MainActivity extends AppCompatActivity implements MainView,View.OnClickListener{

    private TextView text,title;
    private MainPresenter mMainPresenter;
    private Button sava,take;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        text = (TextView) findViewById(R.id.text);
        sava = (Button) findViewById(R.id.sava);
        take = (Button) findViewById(R.id.take);
        title = (TextView) findViewById(R.id.title);
        sava.setOnClickListener(this);
        take.setOnClickListener(this);
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

    @Override
    public String getData() {
        String vaule= text.getText().toString();
        return vaule;
    }

    @Override
    public void setShowData(String getShowData) {
        title.setText(getShowData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sava:
                String data = getData();
                Log.d("zzz3", data);
                mMainPresenter.savaData(data);
                break;
            case R.id.take:
                mMainPresenter.gettakeData();
                break;
        }
    }
}
