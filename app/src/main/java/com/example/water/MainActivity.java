package com.example.water;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.water.Base.BaseListViewActicty;
import com.example.water.Model.HomepageModel;
import com.example.water.Utils.Constants;
import com.example.water.View.HomepageItemView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseListViewActicty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = Constants.BASE_URL + "datastreams?datastream_ids=" + Constants.PARAM_ALL;
        getData(url);
    }

    @Override
    protected int getResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected void handleData(JSONObject responseObject) {
        try {
            JSONArray jsonArray = responseObject.getJSONArray("data");
            Gson gson = new Gson();
            for (int i = 0;i < jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HomepageModel model = gson.fromJson(jsonObject.toString(), HomepageModel.class);
                listArray.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected BaseListAdapter getAdapter() {
        return new CustomAdapter();
    }

    protected class CustomAdapter extends BaseListViewActicty.BaseListAdapter {

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = new HomepageItemView(MainActivity.this);
            }
            HomepageItemView itemView = (HomepageItemView)view;
            itemView.setData((HomepageModel)listArray.get(i));
            return itemView;
        }
    }
}