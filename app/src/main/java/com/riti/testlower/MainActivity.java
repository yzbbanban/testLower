package com.riti.testlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.i(TAG, "onCreate: ++++");
        ConditionModel conditionModel=new ConditionModel();
        conditionModel.login(new ICallBack() {
            @Override
            public void setSuccess(Object message) {
                Log.i(TAG, "setSuccess: "+message);
            }

            @Override
            public void setFailure(Object message) {

            }
        });
    }
}
