package com.riti.testlower.retrofit;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by brander on 2017/8/17.
 */

public abstract class MyCallback<T> implements Callback<T> {
    private static final String TAG = "MyCallback";

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.i(TAG, "onResponse: " + response.body());
        if (response.raw().code() == 200) {//200是服务器有合理响应
            onSuc(response);
        } else {
            onFail("fail");
        }
    }

    public void onFailure(Call<T> call, Throwable t) {//网络问题会走该回调
        if (t instanceof SocketTimeoutException) {
            //
        } else if (t instanceof ConnectException) {
            //
        } else if (t instanceof RuntimeException) {
            //
        }
        onFail(t.getMessage());
    }

    public abstract void onSuc(Response<T> response);

    public abstract void onFail(String message);

}
