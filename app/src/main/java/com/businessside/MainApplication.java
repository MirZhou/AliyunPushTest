package com.businessside;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

public class MainApplication extends Application {
    private static final String TAG = "MyMessage Init Channel";

    @Override
    public void onCreate() {
        super.onCreate();
        this.initCloudChannel(this);
    }

    private void initCloudChannel(Context applicationContext) {
        PushServiceFactory.init(applicationContext);
        CloudPushService pushService = PushServiceFactory.getCloudPushService();

        Log.d(TAG, pushService.getDeviceId());

        pushService.turnOnPushChannel(new CommonCallback() {
            @Override
            public void onSuccess(String status) {
                Log.d(TAG, "Push channel turn is on - - "+ status);
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d(TAG, "Push channel turn on failed - - error code : " + errorCode + " - - errorMessage : " + errorMessage);
            }
        });

        pushService.checkPushChannelStatus(new CommonCallback() {
            @Override
            public void onSuccess(String status) {
                Log.d(TAG, "Push channel status : " + status);
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d(TAG, "Push channel status is off. - - error code : " + errorCode + " - - errorMessage : " + errorMessage);
            }
        });

        pushService.bindAccount("18684107874", new CommonCallback() {
            @Override
            public void onSuccess(String s) {
                Log.d(TAG, "Account bind success " + s);
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d(TAG, "Account bind failed - - error code : " + errorCode + " - - errorMessage : " + errorMessage);
            }
        });

        Log.d(TAG, "=====================DeviceId : " + pushService.getDeviceId());

        pushService.register(applicationContext, new CommonCallback() {
            @Override
            public void onSuccess(String s) {
                Log.d(TAG, "Init cloud channel success");
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d(TAG, "Init cloud chanel failed - - error code : " + errorCode + " - - errorMessage : " + errorMessage);
            }
        });
    }
}
