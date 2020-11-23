package com.example.pigeon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        webView.clearCache(true);
        webView.getSettings().setDomStorageEnabled(true);
        setContentView(webView);
        WebSettings webSettings = webView.getSettings();
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

        //webView.addJavascriptInterface(new webAppInterface(this,this, webView),"webInterface");
        webView.clearHistory();
        webView.clearFormData();
        String url = "file:///android_asset/dist/index.html";
        webView.setWebChromeClient(new WebChromeClient());
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
}