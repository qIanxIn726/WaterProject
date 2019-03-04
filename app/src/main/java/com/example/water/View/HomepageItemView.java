package com.example.water.View;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.water.DetailActivity;
import com.example.water.Model.HomepageModel;
import com.example.water.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomepageItemView extends RelativeLayout {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    private HomepageModel model;
    private Context context;

    public HomepageItemView(Context context) {
        this(context, null);
    }

    public HomepageItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomepageItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.homepage_item_view, this, true);
        ButterKnife.bind(this);
    }

    public void setData(HomepageModel model) {
        this.model = model;
        tvTitle.setText(model.getId());
        tvDetail.setText("最近更新时间：" + model.getUpdateAt());
        tvNumber.setText(model.getCurrentValue() + model.getUnitSymbol());
        //
        ivIcon.setImageResource(model.getIcon());
    }


    @OnClick(R.id.root_view)
    public void onViewClicked() {
        Intent intent = new Intent(this.context, DetailActivity.class);
        intent.putExtra("datastream_id", this.model.getId());
        context.startActivity(intent);
    }
}
