package com.epicodus.dreamwhale.util;

import com.epicodus.dreamwhale.BuildConfig;

/**
 * Created by Guest on 5/10/16.
 */
public class Constants {
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
