package com.example.realtor_lease_platform_android.tool;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.webkit.WebView;
import android.widget.ScrollView;

import com.example.realtor_lease_platform_android.tool.DBConnection;


/**
 * Created by Chris.Wu on 2016/10/20.
 */
public class Factory {

    // change Factory to singleton

    private static final Factory ourInstance = new Factory();

    public static Factory getInstance() {
        return ourInstance;
    }

    private Factory() {
    }

    /*
    public DBConnection createDBConnection(Activity activity) {
        return new DBConnection(activity);
    }

    public DBConnection createDBConnection(Application application) {
        return new DBConnection(application);
    }*/

    public DBConnection createDBConnection(Context context) {
        return new DBConnection(context);
    }

//    public JavaScriptInterface createJavaScriptInterface(Activity activity, WebView webView,Model model,ScrollView scrollView) {
//        return new JavaScriptInterface(activity, webView,model, scrollView);
//    }

    public Model createModel(Activity activity) {
        return new Model(activity);
    }

    public Model createModel(Application application) {
        return new Model(application);
    }

    public Model createModel(Context context) {
        return new Model(context);
    }

    public Model createModel() {
        return new Model();
    }


}
