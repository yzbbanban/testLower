package com.riti.testlower;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by brander on 2017/8/3.
 */

public interface ConditionService {
    @POST("checkCode")
    @FormUrlEncoded
    Call<String> call(@Field("condition") String condition);
}