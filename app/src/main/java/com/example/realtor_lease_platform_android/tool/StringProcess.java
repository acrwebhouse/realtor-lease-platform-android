package com.example.realtor_lease_platform_android.tool;

import com.example.realtor_lease_platform_android.define.Constants;
import com.example.realtor_lease_platform_android.role.Config;

public class StringProcess {

    public static String getQueryConfigWhereStringByPK(Config config) {
        return Constants.ID_SQL + "='" + config.getId() + "'";
    }

    // getJavascriptFunctionString
    public static String getJavascriptFunctionString(String arg, String functionName) {
        String result = Constants.JAVASCRIPT + ":" + Constants.JAVASCRIPT_PARAMETER_FOR_ANDROID + "." + functionName + "('" + arg + "')";
        return result;
    }

    public static String getJavascriptFunctionSetAccountPasswordUrlString(String account,String password) {
        String arg = account + "','" + password;
//        return getJavascriptFunctionString(arg,Constants.SET_ACCOUNT_PASSWORD_JAVASCRIPT);
        return getJavascriptFunctionString(arg,"aaa");
    }

}
