package com.example.realtor_lease_platform_android.tool;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.icu.text.LocaleDisplayNames;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.realtor_lease_platform_android.define.Constants;
import com.example.realtor_lease_platform_android.role.Config;
import com.example.realtor_lease_platform_android.tool.Factory;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris.Wu on 2016/10/20.
 */
public class Model {
    Factory factory = Factory.getInstance();
    DBConnection dbHelper;
    Activity controlActivity;
    HttpClient httpClient;
    Application controlApplication;
    Context controlContext;
    JavaScriptInterface controlJavaScriptInterface;

    public Model() {
        controlActivity = null;
        controlApplication = null;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Activity activity) {
        controlActivity = activity;
        controlContext = null;
        controlApplication = null;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Application application) {
        controlActivity = null;
        controlContext = null;
        controlApplication = application;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Context context) {
        controlActivity = null;
        controlApplication = null;
        controlContext = context;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Activity activity, JavaScriptInterface javaScriptInterface) {
        controlActivity = activity;
        controlContext = null;
        controlApplication = null;
        controlJavaScriptInterface = javaScriptInterface;
        createObj();
    }

    public void setJavaScriptInterface(JavaScriptInterface javaScriptInterface){
        controlJavaScriptInterface = javaScriptInterface;
    }

    private void createObj() {
        httpClient = factory.createHttpClient();
        if (controlActivity != null) {
            dbHelper = factory.createDBConnection(controlActivity);
            dbHelper.DBInit();

        } else if (controlApplication != null) {
            dbHelper = factory.createDBConnection(controlApplication);
            dbHelper.DBInit();
        } else if (controlContext != null) {
            dbHelper = factory.createDBConnection(controlContext);
            dbHelper.DBInit();
        } else {
            dbHelper = null;
        }
    }

    public void initDB(){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if(config == null){
                Config insertConfig = factory.createConfig();
                insertConfig(insertConfig);
            }
        }
    }

    public JSONObject getJsonObject(String JSONString) {
        JSONObject jsonObject = null;
        try {
            if (JSONString.indexOf(Constants.OPEN_BRACE) >= 0) {
                JSONString = JSONString.substring(JSONString.indexOf(Constants.OPEN_BRACE), JSONString.lastIndexOf(Constants.CLOSE_BRACE) + 1);
            }
            jsonObject = new JSONObject(JSONString);
        } catch (JSONException e) {
        }
        return jsonObject;
    }

    public void saveFirebaseToken(String firebaseToken){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if(config != null){
                config.setAttribute(1,firebaseToken);
                updateConfig(config);
            }else{
                Config insertConfig = factory.createConfig();
                insertConfig.setAttribute(1,firebaseToken);
                insertConfig(insertConfig);
            }
        }
    }

    public void saveConfig(String account,String password,String userId){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if (config != null) {
                config.setAttribute(3, account);
                config.setAttribute(4, password);
                config.setAttribute(5, userId);
                updateConfig(config);
            } else {
                Config insertConfig = factory.createConfig();
                config.setAttribute(3, account);
                config.setAttribute(4, password);
                insertConfig.setAttribute(5, userId);
                insertConfig(insertConfig);
            }
        }
    }

    public void saveUserId(String userId){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if (config != null) {
                config.setAttribute(5, userId);
                updateConfig(config);
            } else {
                Config insertConfig = factory.createConfig();
                insertConfig.setAttribute(5, userId);
                insertConfig(insertConfig);
            }
        }
    }

    public void sendNotificationRequest(){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if(config.getNotificationId().equals(Constants.EMPTY_STRING)){
                Log.d("http", "http rest api  addNotification  start         ");
                httpClient.addNotification(config.getFirebaseToken(),config.getUserId(),this);
            }else{
                httpClient.editNotification(config.getFirebaseToken(),config.getUserId(),config.getNotificationId(),this);
            }
        }
    }

    public void saveNotificationId(String notificationId){
        if (dbHelper != null) {
            Config config = dbHelper.getConfig();
            if(config != null){
                config.setAttribute(2,notificationId);
                updateConfig(config);
            }else{
                Config insertConfig = factory.createConfig();
                insertConfig.setAttribute(2,notificationId);
                insertConfig(insertConfig);
            }
        }
    }

    public void insertConfig(Config config) {
        if (dbHelper != null) {
            dbHelper.insertConfig(config);
        }
    }

    public void updateConfig(Config config) {
        if (dbHelper != null) {
            dbHelper.updateConfigByPK(config);
        }
    }

    public Config getConfig() {
        if (dbHelper != null) {
            return dbHelper.getConfig();
        }
        return null;
    }

    public void deleteConfig() {
        if (dbHelper != null) {
            dbHelper.deleteConfig();
        }
    }

    public void autoLogin(String loadUrl){
        Config config = getConfig();
        String account = config.getAccount();
        String password = config.getPassword();
        if(account.equals(Constants.EMPTY_STRING) == true || password.equals(Constants.EMPTY_STRING) == true){
            controlJavaScriptInterface.loadUrl(Constants.EMPTY_STRING);
        }else{
            httpClient.login(account,password,this,controlJavaScriptInterface,loadUrl);
        }

    }

}
