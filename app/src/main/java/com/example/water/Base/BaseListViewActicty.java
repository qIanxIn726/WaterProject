package com.example.water.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.water.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public abstract class BaseListViewActicty extends BaseActicty {

    @BindView(R.id.list_view)
    ListView listView;

    protected List listArray = new ArrayList<>();
    protected BaseListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = getAdapter();
        listView.setAdapter(adapter);
    }

    protected abstract BaseListAdapter getAdapter();

    public class BaseListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listArray.size();
        }

        @Override
        public Object getItem(int i) {
            return listArray.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
