package com.example.realtor_lease_platform_android.define;

/**
 * Created by Chris.Wu on 2016/10/21.
 */
public class Constants {
    public static String SERVER_URL = "https://matchrentdev.com/";
//      public static String SERVER_URL = "http://192.168.0.10:3000/";

    //web url
    public static final String NETWORK_ERROR_WEB_URL = "file:///android_asset/networkErrorWeb.html";
//    public static final String NETWORK_ERROR_WEB_URL = "file:///asset/networkErrorWeb.html";
//    public static final String ACTION_LOG_WEB_URL = "file:///android_asset/actionLogWeb.html";
//    public static final String ALARM_LOG_WEB_URL = "file:///android_asset/alarmLogWeb.html";
//    public static final String ALARM_SUMMARY_LOG_WEB_URL = "file:///android_asset/alarmSummaryLogWeb.html";
//    public static final String SINGLE_VALUE_URL = "file:///android_asset/loginWeb.html";
//    public static final String CONFIG_WEB_URL = "file:///android_asset/configWeb.html";
//    public static final String HOME_WEB_URL = "file:///android_asset/homeWeb.html";
//    public static final String IP_INPUT_WEB_URL = "file:///android_asset/ipInputWeb.html";
//    public static final String LOGIN_WEB_URL = "file:///android_asset/loginWeb.html";

    public static final String ACTION_LOG_WEB_URL = "file:///android_asset/actionLog.html";
    public static final String ALARM_LOG_WEB_URL = "file:///android_asset/alarmLog.html";
    public static final String ALARM_SUMMARY_LOG_WEB_URL = "file:///android_asset/alarmSummary.html";
    public static final String SINGLE_VALUE_URL = "file:///android_asset/login.html";
    public static final String CONFIG_WEB_URL = "file:///android_asset/config.html";
    public static final String HOME_WEB_URL = "file:///android_asset/home.html";
    public static final String IP_INPUT_WEB_URL = "file:///android_asset/ipInput.html";
    public static final String LOGIN_WEB_URL = "file:///android_asset/login.html";
    public static final String TREND_WEB_URL = "file:///android_asset/trend.html";
    public static final String TREND_LIST_WEB_URL = "file:///android_asset/trendList.html";
    public static final String TAGS_INFO_GROUP_WEB_URL = "file:///android_asset/tagsInfoGroup.html";
    public static final String TAGS_INFO_LIST_WEB_URL = "file:///android_asset/tagsInfoList.html";
    public static final String TAGS_INFO_VALUE_WEB_URL = "file:///android_asset/tagsInfoValue.html";
    public static final String GOOGLE_MAP_WEB_URL = "file:///android_asset/googleMap.html";
    public static final String NODE_STATUS_WEB_URL = "file:///android_asset/nodeStatus.html";
    public static String DASHBOARD_VIEW_WEB_URL = SERVER_URL+"/wadashboard/dashboardviewer";

    public static final String MAP_LOCAL_WEB_URL = "file:///android_asset/map.html";
    public static final String BAIDU_MAP_LOCAL_WEB_URL = "file:///android_asset/bmapPage.html";
    public static final String MAP_LIST_LOCAL_WEB_URL = "file:///android_asset/mapList.html";

    //javascript
    public static final String ANDROID_PARAMETER_FOR_JAVASCRIPT = "appJsInterface";
    public static final String JAVASCRIPT_PARAMETER_FOR_ANDROID = "jsAppInterface";
    public static final String SET_ACCOUNT_PASSWORD_JAVASCRIPT = "setDefaultAccountPassword";


    //permissions
    public static final int SYSTEM_ALERT_WINDOW_PERMISSIONS_REQUEST_CODE = 0;
    public static final int WRITE_EXTERNAL_STORAGE_PERMISSIONS_REQUEST_CODE = 1;

    //sqlite
    public static final String DATABASE_NAME = "ACRDB";
    public static final int DATABASE_VERSION = 1;
    public static final String ID_SQL = "id";
    //table user
    public static final String TABLE_USER_SQL = "User";
    public static final String USER_ID_SQL = "UserId";
    public static final String USER_USERNAME_SQL = "username";
    public static final String USER_PASSWORD_SQL = "password";
    public static final String USER_PROJECT_NAME_SQL = "projectName";
    public static final String USER_SERVER_TOKEN_SQL = "serverToken";
    public static final String USER_SERVER_IP_SQL = "ip";
    public static final String USER_TABLE_CREATE_SQL = "CREATE TABLE "
            + TABLE_USER_SQL + " ( "
            + USER_USERNAME_SQL + " text not null ," + USER_PASSWORD_SQL + " text not null ,"
            + USER_PROJECT_NAME_SQL + " text not null ,"+ USER_SERVER_TOKEN_SQL + " text not null ,"
            + USER_SERVER_IP_SQL + " text not null ,"
            + "CONSTRAINT "+USER_ID_SQL+" PRIMARY KEY ("+USER_USERNAME_SQL+","+USER_PROJECT_NAME_SQL+","+USER_SERVER_IP_SQL+")); ";


    //table config
    public static final String TABLE_CONFIG_SQL = "Config";
    public static final String CONFIG_FIREBASE_TOKEN_SQL = "firebaseToken";
    public static final String CONFIG_NOTIFICATION_ID_SQL = "notificationId";
    public static final String CONFIG_ACCOUNT_SQL = "account";
    public static final String CONFIG_PASSWORD_SQL = "password";
    public static final String CONFIG_USER_ID_SQL = "userId";

    public static final String CONFIG_TABLE_CREATE_SQL = "CREATE TABLE "
            + TABLE_CONFIG_SQL + " ( " + ID_SQL + "  INTEGER primary key autoincrement, "
            + CONFIG_FIREBASE_TOKEN_SQL + " text not null,"
            + CONFIG_NOTIFICATION_ID_SQL + " text not null,"
            + CONFIG_ACCOUNT_SQL + " text not null,"
            + CONFIG_PASSWORD_SQL + " text not null,"
            + CONFIG_USER_ID_SQL + " text not null"
            +"); ";


    //util
    public static final String OPEN_BRACE = "{";
    public static final String CLOSE_BRACE = "}";
    public static final String USER_ID = "userId";
    public static final String TOKEN = "token";
    public static final String ANDROID_NOTIFICATION_TYPE = "1";
    public static final String RESULT_REST_API = "resStatus";
    public static final String RES_STRING_REST_API = "resString";
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String HTTP = "http:";
    public static final String HTTPS = "https:";
    public static final String SLASH = "//";
    public static final String EMPTY_STRING = "";
    public static final String IP = "ip";
    public static final String USERNAME = "username";
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    public static final String REMEMBER = "remember";
    public static final String TYPE = "type";
    public static final String PROJECT_NAME = "projectName";
    public static final String PROJECT_NAME_1 = "projectName1";
    public static final String PROJECT = "project";
    public static final String TRUE_STRING = "true";
    public static final String FALSE_STRING = "false";
    public static final String FIREBASE_TOKEN = "firebaseToken";
    public static final String DOUBLE_QUOTES="\"";
    public static final String JAVASCRIPT="javascript";
    public static final String IP_LIST="ipList";
    public static final String PROJECT_LIST="projectList";
    public static final String ACCOUNT_LIST="accountList";
    public static final String FUNCTION_LIST="funcList";
    public static final String HTTP_FAIL="{"+DOUBLE_QUOTES+RESULT_REST_API+DOUBLE_QUOTES+":"+ONE+"}";
    public static final String URL="url";
    public static final String START="start";
    public static final String COUNT="count";
    public static final String FILTERS="filters";
    public static final String SORT="sort";
    public static final String COOKIE="Cookie";
    public static final String STATUS = "status";
    public static final String DATA = "data";
    public static final String SERVER_TOKEN_TITLE="WDT=";
    public static final String SEMICOLON=";";
    public static final String _ID = "_id";
    public static final String ID = "id";
    public static final String NOTIFICATION_NO_MATCH_ID = "no match id";

    //rest api
    public static String ADD_NOTIFICATION_REST_API = SERVER_URL + "user-service/notification/addNotification";
    public static String EDIT_NOTIFICATION_REST_API = SERVER_URL + "user-service/notification/editNotification";

}
