package com.example.appbandoan.utils;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MySharedPreferences {
    private final android.content.SharedPreferences prefs;

    public MySharedPreferences(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUserName(String username) {
        prefs.edit().putString("username", username).apply();
    }

    public String getUserName() {
        return prefs.getString("username","");
    }



}
