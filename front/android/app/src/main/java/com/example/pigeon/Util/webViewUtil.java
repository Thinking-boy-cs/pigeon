package com.example.pigeon.Util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

import com.example.pigeon.MainActivity;

import com.example.pigeon.R;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class webViewUtil {
    private Activity activity;
    private Intent intent;
    private String fileName;
    private Bitmap photofile = null;
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
        webView.addJavascriptInterface(new webViewUtil(activity),"webViewUtil");
        return webSettings;
    }
    @SuppressLint("MissingPermission")
    @JavascriptInterface
    public String getLocationInfo(){
        String result = null;
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
    private void verifyStoragePermissions(Activity activity) {
        int permissionWrite = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionWrite != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
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
    @JavascriptInterface
    public void TakePhoto() {
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStorageDirectory();
        fileName = System.currentTimeMillis()+".jpg";
        File file = new File(dir,fileName);
        Uri uri = FileProvider.getUriForFile(activity,activity.getPackageName()+".provider",file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        activity.startActivityForResult(intent, 1);
        //uri = FileProvider.getUriForFile(activity,activity.getPackageName()+".provider",file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,photofile);
        String result = bitmapToBase64(photofile);
    }
    @JavascriptInterface
    public String getPhotoData(){
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir,fileName);
        Uri uri = FileProvider.getUriForFile(activity,activity.getPackageName()+".provider",file);
        try {
            photofile = BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(uri));

            photofile = Bitmap.createScaledBitmap(photofile, 300, 300, true);
            photofile = adjustPhotoRotation(photofile, 90);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String result = bitmapToBase64(photofile);
        return result;
    }
    public Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree)
    {

        Matrix m = new Matrix();
        m.setRotate(orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);
        float targetX, targetY;
        if (orientationDegree == 90) {
            targetX = bm.getHeight();
            targetY = 0;
        } else {
            targetX = bm.getHeight();
            targetY = bm.getWidth();
        }

        final float[] values = new float[9];
        m.getValues(values);

        float x1 = values[Matrix.MTRANS_X];
        float y1 = values[Matrix.MTRANS_Y];
        m.postTranslate(targetX - x1, targetY - y1);
        Bitmap bm1 = Bitmap.createBitmap(bm.getHeight(), bm.getWidth(), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bm1);
        canvas.drawBitmap(bm, m, paint);
        return bm1;
    }
    private String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
