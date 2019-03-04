package com.example.water.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.water.Model.DetailModel;
import com.example.water.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailItemView extends RelativeLayout {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    /*@BindView(R.id.tv_number)
    TextView tvNumber;*/

    public DetailItemView(Context context) {
        this(context, null);
    }

    public DetailItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DetailItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.detail_item_view, this, true);
        ButterKnife.bind(this);
    }

    public void setData(DetailModel model) {
        tvTitle.setText(model.getValue());
        tvDetail.setText(model.getAt());
        //tvNumber.setText(model.getUnitSymbol());
    }
}
