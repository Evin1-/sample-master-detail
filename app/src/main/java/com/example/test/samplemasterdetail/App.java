package com.example.test.samplemasterdetail;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by evin on 3/10/16.
 */
public class App extends Application {

    // TODO: 3/10/16 Remove created by 'Evin'
    // TODO: 3/10/16 Click on item
    // TODO: 3/10/16 Save on rotation
    // TODO: 3/10/16 Remove unused strings values

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
