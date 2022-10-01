package com.example.realtor_lease_platform_android.tool;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.example.realtor_lease_platform_android.role.Config;

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
    public void saveUserInfo(final String accoun,final String password,final String userId) {
        Log.d(TAG, "  saveUserInfo  accoun " + accoun);
        Log.d(TAG, "  saveUserInfo  password " + password);
        Log.d(TAG, "  saveUserInfo  userId " + userId);
        controlModel.saveConfig(accoun,password,userId);
        controlModel.sendNotificationRequest();
    }

    @JavascriptInterface
    public void setAccountPassword() {
        Log.d(TAG, "  setAccountPassword   " );
        Config config =controlModel.getConfig();
        String account = config.getAccount();
        String password = config.getPassword();
        Log.d(TAG, "  account   "+account );
        Log.d(TAG, "  password   " +password);
        String setAccountPasswordUrl = StringProcess.getJavascriptFunctionSetAccountPasswordUrlString(account,password);
        Log.d(TAG, "  setAccountPassword  setAccountPasswordUrl " +setAccountPasswordUrl);
//        controlWebView.loadUrl(setAccountPasswordUrl);
    }
}
