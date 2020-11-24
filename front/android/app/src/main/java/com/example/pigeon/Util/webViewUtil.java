package com.example.pigeon.Util;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.pigeon.MainActivity;
import com.example.pigeon.R;
import com.tencent.smtt.sdk.WebView;


public class webViewUtil {
    private View view;
    private Activity activity;
    private Intent intent;
    public webViewUtil(Activity activity){
        this.activity = activity;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @JavascriptInterface
    public void popInfo(String channelId, String channelName, int importance, String url, String title, String content){
        //String channelId = "signIn";
        //String channelName = "remindInfo";
        //int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel(channelId,channelName,importance);
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(activity.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        //WebView webView = new WebView(activity);
        intent = new Intent(Intent.ACTION_VIEW,Uri.parse("assets://dist/index.html"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(activity,0,intent,0);
        Notification notification = new NotificationCompat.Builder(activity,channelId)
                .setSmallIcon(R.mipmap.app_logo)
                .setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setWhen(System.currentTimeMillis())
                .build();
        notificationManager.notify(2,notification);
    }

}
