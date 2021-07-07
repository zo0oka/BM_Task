package com.zo0okadev.bmtask;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
