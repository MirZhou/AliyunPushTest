package com.receiver;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.push.MessageReceiver;
import com.alibaba.sdk.android.push.notification.CPushMessage;

import java.util.Map;

public class MyMessageReceiver extends MessageReceiver {
    private static final String REC_TAG = "MyMessage Receiver";

    @Override
    protected void onNotification(Context context, String title, String summary, Map<String, String> extraMap) {
        // 处理推送通知
        StringBuilder sbMsg = new StringBuilder();
        sbMsg.append("Receive notification");
        sbMsg.append(",");
        sbMsg.append("title: " + title);
        sbMsg.append(",");
        sbMsg.append("summary: " + summary);
        sbMsg.append(",");
        sbMsg.append("extraMap: " + extraMap);

        Log.e(REC_TAG, sbMsg.toString());
    }

    @Override
    protected void onMessage(Context context, CPushMessage cPushMessage) {
        StringBuilder sbMsg = new StringBuilder();
        sbMsg.append("onMessage");
        sbMsg.append(",");
        sbMsg.append("messageId: " + cPushMessage.getMessageId());
        sbMsg.append(",");
        sbMsg.append("title: " + cPushMessage.getTitle());
        sbMsg.append(",");
        sbMsg.append("content: " + cPushMessage.getContent());

        Log.e(REC_TAG, sbMsg.toString());
    }

    @Override
    protected void onNotificationOpened(Context context, String title, String summary, String extraMap) {
        StringBuilder sbMsg = new StringBuilder();
        sbMsg.append("onNotificationOpened");
        sbMsg.append(",");
        sbMsg.append("title: " + title);
        sbMsg.append(",");
        sbMsg.append("summary: " + summary);
        sbMsg.append(",");
        sbMsg.append("extraMap: " + extraMap);

        Log.e(REC_TAG, sbMsg.toString());
    }

    @Override
    protected void onNotificationClickedWithNoAction(Context context, String title, String summary, String extraMap) {
        StringBuilder sbMsg = new StringBuilder();
        sbMsg.append("onNotificationClickedWithNoAction");
        sbMsg.append(",");
        sbMsg.append("title: " + title);
        sbMsg.append(",");
        sbMsg.append("summary: " + summary);
        sbMsg.append(",");
        sbMsg.append("extraMap: " + extraMap);

        Log.e(REC_TAG, sbMsg.toString());
    }

    @Override
    protected void onNotificationReceivedInApp(Context context, String title, String summary, Map<String, String> extraMap, int openType, String openActivity, String openUrl) {
        StringBuilder sbMsg = new StringBuilder();
        sbMsg.append("onNotificationReceivedInApp");
        sbMsg.append(",");
        sbMsg.append("title: " + title);
        sbMsg.append(",");
        sbMsg.append("summary: " + summary);
        sbMsg.append(",");
        sbMsg.append("extraMap: " + extraMap);
        sbMsg.append(",");
        sbMsg.append("openType: " + openType);
        sbMsg.append(",");
        sbMsg.append("openActivity: " + openActivity);
        sbMsg.append(",");
        sbMsg.append("openUrl: " + openUrl);

        Log.e(REC_TAG, sbMsg.toString());
    }

    @Override
    protected void onNotificationRemoved(Context context, String messageId) {
        Log.e(REC_TAG, "onNotificationRemoved");
    }
}