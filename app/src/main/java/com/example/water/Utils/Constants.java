package com.example.water.Utils;

public class Constants {
    //设备ID
    public static String DEVICE_ID = "502129186";
    //API的baseURL
    public static String BASE_URL = "http://api.heclouds.com/devices/" + DEVICE_ID +"/";
    //污水处理参数
    public static String PARAM_COD = "Cod";
    public static String PARAM_TOC = "Toc";
    public static String PARAM_BOD = "Bod";
    public static String PARAM_NTU = "NTU";
    public static String PARAM_TSS = "Tss";
    public static String PARAM_TEMPRETURE = "Tempreture";
    public static String PARAM_PH = "PH";
    public static String PARAM_TDS = "TDS";
    public static String PARAM_ALL = "Cod,Toc,Bod,NTU,Tss,Tempreture,PH,TDS";
}
