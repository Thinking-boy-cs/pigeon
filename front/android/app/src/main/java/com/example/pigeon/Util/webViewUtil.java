package com.example.pigeon.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.pigeon.MainActivity;
import com.example.pigeon.R;
import com.example.pigeon.TestActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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
    @SuppressLint("MissingPermission")
    @JavascriptInterface
    public String getLocationInfo(){
        String result;
        LocationManager locationManager = (LocationManager) activity.getSystemService(activity.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if(!isGpsAble(locationManager)) {
            openGPS();
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 8, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                update(location);
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }
            @Override
            public void onProviderEnabled(String s) {
                update(locationManager.getLastKnownLocation(s));
            }
            @Override
            public void onProviderDisabled(String s) {
                update(null);
            }
        });
        result = update(location);
        return result;
    }
    @JavascriptInterface
    public String jsonToHtml(double Longitude, double Latitude){
        JSONObject json;
        JSONArray jsonArray = new JSONArray();
        try{
            json = new JSONObject();
            json.put("Longitude",Longitude);
            json.put("Latitude",Latitude);
            jsonArray.put(json);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonArray.toString();
    }
    private boolean isGpsAble(LocationManager lm){
        return lm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)?true:false;
    }
    private void openGPS(){
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        activity.startActivityForResult(intent,0);
    }
    private String update(Location location){
        return jsonToHtml(location.getLongitude(),location.getLatitude());
    }

}
