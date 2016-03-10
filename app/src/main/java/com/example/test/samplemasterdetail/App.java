package com.example.test.samplemasterdetail;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by evin on 3/10/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
