package com.example.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by 宇宙真理天下第一 on 2020/1/15.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}

