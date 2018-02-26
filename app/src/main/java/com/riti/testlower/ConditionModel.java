package com.riti.testlower;

import android.util.Log;

import com.riti.testlower.retrofit.RetrofitUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by brander on 2017/9/24.
 */

public class ConditionModel {
    private static final String TAG = "ConditionModel";
    String l = "";

    public void login(final ICallBack callback) {

        Log.i(TAG, "login: ====>");
        String url = "http://xinlingyu.shyuying.cn/index.php/Home/index/";
        final ConditionService request = RetrofitUtils.getRetrofit(url).create(ConditionService.class);
        for (int i = 0; i < 10000; i++) {
            l = "" + i;
            switch (l.length()) {
                case 1:
                    l = "0000" + l;
                    break;
                case 2:
                    l = "000" + l;
                    break;
                case 3:
                    l = "00" + l;
                    break;
                case 4:
                    l = "0" + l;
                    break;
            }
            Log.i(TAG, "login: XLY"+l);
            //"XLY08755"
            Call<String> call = request.call("XLY"+l);
            call.enqueue(new Callback<String>() {

                @Override
                public void onResponse(Call<String> call, Response<String> response) {
//                    Log.i(TAG, "onResponse: "+response.body());
                    String result = response.body();

                    String lower = "";
                    if (result.contains("<img src=\"http:") || result.contains("恭喜")) {
//                        Log.i(TAG, "onResponse: ++++");
                        lower = result.substring(result.indexOf("<img src=\"http:") + 10, result.indexOf("width=\"80%\"") - 2);
//                    Log.i(TAG, "onResponse: lower " + lower);
                        callback.setSuccess(l+" "+lower);
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.i(TAG, "onFailure: " + t.getMessage());
                }
            });
        }

    }
}
