package com.example.water.Model;

import com.example.water.R;
import com.example.water.Utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class HomepageModel {

    public static Map<String, Integer> paramIconMap = new HashMap<String, Integer>(){
        {
            put(Constants.PARAM_COD, R.mipmap.param_icon_0);
            put(Constants.PARAM_TOC, R.mipmap.param_icon_1);
            put(Constants.PARAM_BOD, R.mipmap.param_icon_2);
            put(Constants.PARAM_NTU, R.mipmap.param_icon_3);
            put(Constants.PARAM_TSS, R.mipmap.param_icon_4);
            put(Constants.PARAM_TEMPRETURE, R.mipmap.param_icon_5);
            put(Constants.PARAM_PH, R.mipmap.param_icon_6);
            put(Constants.PARAM_TDS, R.mipmap.param_icon_7);
        }
    };


    /**
     * update_at : 2018-12-22 14:36:17
     * unit :
     * id : Toc
     * unit_symbol : mg/l
     * current_value : 137.00
     */

    @SerializedName("update_at")
    private String updateAt;

    private String unit;
    private String id;

    @SerializedName("unit_symbol")
    private String unitSymbol;

    @SerializedName("current_value")
    private String currentValue;

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public int getIcon() {
        return paramIconMap.get(getId());
    }
}
