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
    // TODO: 3/10/16 Add scrolling behavior
    // TODO: 3/13/16 Check if details is empty on tablet layout
    // TODO: 3/13/16 Make DetailsActivity pretty
    // TODO: 3/13/16 Create note docs and commenting 
    // TODO: 3/13/16 Implement local search functionality
    // TODO: 3/13/16 Favorite characters
    // TODO: 3/13/16 Add animations

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
