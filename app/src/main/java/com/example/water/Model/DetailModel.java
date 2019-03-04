package com.example.water.Model;

import com.google.gson.annotations.SerializedName;

public class DetailModel {

    /**
     * at : 2017-06-23 11:11:12.839
     * value : ad3
     */

    @SerializedName("at")
    private String at;

    @SerializedName("value")
    private String value;

    private String unitSymbol;

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }
}
