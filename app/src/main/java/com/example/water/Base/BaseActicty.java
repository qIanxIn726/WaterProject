package com.example.water.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.water.Utils.HttpUtils;

import org.json.JSONObject;

import butterknife.ButterKnife;

public abstract class BaseActicty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceID());
        ButterKnife.bind(this);
    }

    protected abstract int getResourceID();

    protected abstract void handleData(JSONObject responseObject);

    public void getData(final String url){
        HttpUtils.getData(this, url, new HttpUtils.RequestDataCallback() {
            @Override
            public void onSuccess(final JSONObject responseObject) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleData(responseObject);
                    }
                });
            }
        });
    }

}
