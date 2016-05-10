package com.epicodus.dreamwhale;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Guest on 5/10/16.
 */
public class DreamWhaleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
