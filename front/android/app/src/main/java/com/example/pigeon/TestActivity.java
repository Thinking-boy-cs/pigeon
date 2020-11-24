package com.example.pigeon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pigeon.Util.webViewUtil;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class TestActivity extends AppCompatActivity {
    WebView webView = null;
    WebSettings webSettings = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webViewUtil webViewutil = new webViewUtil(this);
        webView = webViewutil.getWebView();
        webSettings = webViewutil.getSetting(webView);
        setContentView(webView);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        webView.loadUrl(url);
    }

}
