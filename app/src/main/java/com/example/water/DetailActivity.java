package com.example.water;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.water.Base.BaseListViewActicty;
import com.example.water.Model.DetailModel;
import com.example.water.Utils.Constants;
import com.example.water.View.DetailItemView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailActivity extends BaseListViewActicty {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String datastreamId = getIntent().getStringExtra("datastream_id");
        tvTitle.setText(datastreamId);
//        http://api.heclouds.com/devices/502129186/datapoints?datastream_id=Cod&amp;start=2017-01-01T00:00:00&amp;limit=100
//        http://api.heclouds.com/devices/502129186/datapoints?datastream_id=Cod&amp;start=2018-11-25T00:00:00&amp;limit=1000&amp;cursor=182370_502129186_1543116108193
//      APIKey :vL3MUb=BBsmII6Q6scQNlArS1ck=
        // 创建URL 获取某一参数最近一百条历史数据
        String url = Constants.BASE_URL + "datapoints?datastream_id=" + datastreamId + "&limit=100";
        getData(url);
        /*String url = Constants.BASE_URL + "datastreams/" + datastreamId ;//+ "&amp;start=2018-11-25T00:00:00&amp;limit=1000&amp;cursor=182370_502129186_1543116108193 ";
        getData(url);*/
    }

    @Override
    protected int getResourceID() {
        return R.layout.activity_detail;
    }

    @Override
    protected void handleData(JSONObject responseObject) {
        try {
            JSONObject dataObject = responseObject.getJSONObject("data");
            JSONArray datastreams = dataObject.getJSONArray("datastreams");
            if (datastreams.length() > 0) {
                JSONObject itemData = datastreams.getJSONObject(0);
                JSONArray dataArray = itemData.getJSONArray("datapoints");
                Gson gson = new Gson();
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject jsonObject = dataArray.getJSONObject(i);
                    DetailModel model = gson.fromJson(jsonObject.toString(), DetailModel.class);
                    listArray.add(model);
                }
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

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }

    protected class CustomAdapter extends BaseListViewActicty.BaseListAdapter {

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new DetailItemView(DetailActivity.this);
            }
            DetailItemView itemView = (DetailItemView) view;
            itemView.setData((DetailModel) listArray.get(i));
            return itemView;
        }
    }
}
