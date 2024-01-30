package com.example.realtor_lease_platform_android.tool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.example.realtor_lease_platform_android.define.Constants;
import com.example.realtor_lease_platform_android.role.Config;

public class JavaScriptInterface {
    private final String TAG = "JavaScriptInterface";
    private WebView controlWebView;
    private Model controlModel;
    private Activity controlActivity;

    public JavaScriptInterface(Activity activity ,WebView webView, Model model
    ){
        controlWebView = webView;
        controlModel = model;
        controlActivity = activity;
    }

    @JavascriptInterface
    public void saveUserInfo(final String account,final String password,final String userId) {
        Log.d(TAG, "  saveUserInfo  account " + account);
        Log.d(TAG, "  saveUserInfo  password " + password);
        Log.d(TAG, "  saveUserInfo  userId " + userId);
        controlModel.saveConfig(account,password,userId);
        //controlModel.sendNotificationRequest();
    }

    @JavascriptInterface
    public void setAccountPassword() {
        Log.d(TAG, "  setAccountPassword   " );
        Config config =controlModel.getConfig();
        String account = config.getAccount();
        String password = config.getPassword();
        Log.d(TAG, " setAccountPassword account   "+account );
        Log.d(TAG, " setAccountPassword password   " +password);
        String setAccountPasswordUrl = StringProcess.getJavascriptFunctionSetAccountPasswordUrlString(account,password);
        Log.d(TAG, "  setAccountPassword  setAccountPasswordUrl " +setAccountPasswordUrl);
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(setAccountPasswordUrl);
            }
        });

    }

    @JavascriptInterface
    public void backPage() {
        Log.d(TAG, "  backPage   " );
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.goBack();
            }
        });
    }

    @JavascriptInterface
    public void restartApp() {
        Log.d(TAG, "  restartApp   " );
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.SERVER_URL);
            }
        });
    }

    @JavascriptInterface
    public void loadUrl(final String url) {
        Log.d(TAG, "  loadUrl  url " +url);
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.SERVER_URL + url);
            }
        });
    }

    @JavascriptInterface
    public void callUp(final String phoneNumber) {
        Log.d(TAG, "  callUp  phoneNumber " + phoneNumber);
        // 要撥打的電話號碼
        String callNumber = "tel:" + phoneNumber;

        // 建立一個 Intent 物件，指定動作為 ACTION_CALL
        Intent dialIntent = new Intent(Intent.ACTION_CALL);

        // 設定 Uri，表示要執行的動作和資料
        dialIntent.setData(Uri.parse(callNumber));
        try {
            controlActivity.startActivity(dialIntent);
        }catch (Error error){

        }

    }

    @JavascriptInterface
    public void addLineFriend(final String lineId) {
        Log.d(TAG, "  addLineFriend  lineId " + lineId);

    }

    @JavascriptInterface
    public void saveNotificationInfo(final String xToken) {
        Log.d(TAG, "  saveNotificationInfo  xToken " + xToken);
        controlModel.sendNotificationRequest(xToken);
    }

    @JavascriptInterface
    public void showInternelErrorPage() {
        Log.d(TAG, "showInternelErrorPage");
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.NETWORK_ERROR_WEB_URL);
            }
        });
    }


    @JavascriptInterface
    public void autoLogin(String refreshToken, String loadUrl) {
        Log.d(TAG, "autoLogin loadUrl : "+loadUrl);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookieStr = StringProcess.getCookieTokenRow(refreshToken);
        cookieManager.setCookie(Constants.SERVER_URL, cookieStr);
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(loadUrl);
            }
        });
    }
}
