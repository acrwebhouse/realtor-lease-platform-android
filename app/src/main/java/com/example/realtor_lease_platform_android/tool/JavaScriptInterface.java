package com.example.realtor_lease_platform_android.tool;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class JavaScriptInterface {
    private final String TAG = "JavaScriptInterface";
    private WebView controlWebView;
    private Model controlModel;

    public JavaScriptInterface(WebView webView, Model model
    ){
        controlWebView = webView;
        controlModel = model;
    }

    @JavascriptInterface
    public void saveUserId(final String userId) {
        Log.d(TAG, "  saveUserId   " + userId);
        controlModel.saveUserId(userId);
        controlModel.sendNotificationRequest();
    }
}
