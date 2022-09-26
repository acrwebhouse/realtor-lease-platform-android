package com.example.realtor_lease_platform_android.role;

import com.example.realtor_lease_platform_android.define.Constants;

public class Config {
    private int id;
    private String firebaseToken;
    private String account;
    private String password;
    private String notificationId;

    public Config(){
        id = 0;
        firebaseToken = Constants.EMPTY_STRING;
        account = Constants.EMPTY_STRING;
        password = Constants.EMPTY_STRING;
        notificationId = Constants.EMPTY_STRING;
    }

    public Config(int id,String firebaseToken,String account,String password,String notificationId){
        this.id = id;
        this.firebaseToken = firebaseToken;
        this.account = account;
        this.password = password;
        this.notificationId = notificationId;
    }

    public Config(String firebaseToken,String account,String password,String notificationId){
        this.id = 0;
        this.firebaseToken = firebaseToken;
        this.account = account;
        this.password = password;
        this.notificationId = notificationId;
    }

    public void setAttribute(int type, String attribute) {
        switch (type) {
            case 0:
                this.id = Integer.parseInt(attribute);
                break;
            case 1:
                this.firebaseToken = attribute;
                break;
            case 2:
                this.notificationId = attribute;
                break;
            case 3:
                this.account = attribute;
                break;
            case 4:
                this.password = attribute;
                break;
            default:
        }
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public String getNotificationId() {
        return notificationId;
    }
}
