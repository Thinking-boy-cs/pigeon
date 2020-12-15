package com.example.pigeon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;

import com.example.pigeon.Util.webViewUtil;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private WebView webView = null;
    private WebSettings webSettings = null;
    String url = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webViewUtil webViewutil = new webViewUtil(this);
        webView = webViewutil.getWebView();
        webSettings = webViewutil.getSetting(webView);
        setContentView(webView);

        //webView.clearHistory();
        //webView.clearFormData();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
            url = bundle.getString("url");
        if(url == null){
            //url = "file:///android_asset/dist/index.html";
            url = "file:///android_asset/webFile/test.html";
        }
        //System.out.println(url);
        webView.setWebChromeClient(new WebChromeClient());
        //webView.addJavascriptInterface(webViewutil,"webViewUtil");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.e("err", "onReceivedError:" + error.getDescription() + " url:" + request.getUrl());

            }
        });
        webView.loadUrl(url);
    }


    protected void onResume() {
        super.onResume();
        //恢复webview的状态（不靠谱）
        //webView.resumeTimers();
        //激活webView的状态，能正常加载网页
        webView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //当页面被失去焦点被切换到后台不可见状态，需要执行onPause
        //通过onPause动作通知内核暂停所有的动作，比如DOM的解析、plugin的执行、JavaScript执行。
        webView.onPause();

        //当应用程序(存在webview)被切换到后台时，这个方法不仅仅针对当前的webview而是全局的全应用程序的webview
        //它会暂停所有webview的layout，parsing，javascripttimer。降低CPU功耗。（不靠谱）
        //webView.pauseTimers();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data, String fileName) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            File dir = Environment.getExternalStorageDirectory();
            File file = new File(dir, fileName);
            Uri uri = FileProvider.getUriForFile(MainActivity.this, getPackageName() + ".provider", file);
            try {
                Bitmap photofile = BitmapFactory.decodeStream(MainActivity.this.getContentResolver().openInputStream(uri));
                String test = bitmapToBase64(photofile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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