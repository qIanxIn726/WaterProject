package com.example.water.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {

    private static String TAG = "HttpUtils";

    public interface RequestDataCallback {
        void onSuccess(JSONObject responseObject);
    }

    public static void getData(final Context context, final String Url, final RequestDataCallback requestDataCallback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Url)
                .addHeader("api-key", "vL3MUb=BBsmII6Q6scQNlArS1ck=")
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
                Toast.makeText(context, "please check network state！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String dataStr = response.body().string();
                try {
                    JSONObject responseObject = new JSONObject(dataStr);
                    int errno = responseObject.getInt("errno");
                    if (errno == 0){//请求成功
                        requestDataCallback.onSuccess(responseObject);
                        //Toast.makeText(context, "getData success！", Toast.LENGTH_SHORT).show();
                    }else{//请求失败
                        Toast.makeText(context, "server error code: " + responseObject.getString("error"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "Url:\n"+Url+"\nonResponse: " + dataStr);
            }
        });
    }

    // TODO: 2018/12/22 post请求
    public void postData() {
    }
}
