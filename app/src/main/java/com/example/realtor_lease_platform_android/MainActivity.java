package com.example.realtor_lease_platform_android;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "http://34.81.209.11:8080/";
    //private String url = "http://www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(webViewClient);
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);//加载url

        webSettings.setDisplayZoomControls(false);
    }

    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient = new WebViewClient() {

    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("ansen", "是否有上一个页面:" + webView.canGoBack());
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
            webView.goBack(); // goBack()表示返回webView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}