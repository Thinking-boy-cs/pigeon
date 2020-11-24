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
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.pigeon.MainActivity;
import com.example.pigeon.R;
import com.example.pigeon.TestActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;


public class webViewUtil {
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
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        intent = new Intent(activity, MainActivity.class);
        intent.putExtras(bundle);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
    public WebView getWebView(){
            WebView webView = new WebView(activity);
            webView.clearCache(true);
            return webView;
    }
    public WebSettings getSetting(WebView webView){
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);  //提高渲染的优先级
        webSettings.setAppCacheEnabled(false);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片

        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setGeolocationEnabled(true);//允许网页执行定位操作
        webSettings.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");//设置User-Agent
        //webView.addJavascriptInterface(new webViewUtil(activity),"webViewUtil");
        return webSettings;
    }
}
