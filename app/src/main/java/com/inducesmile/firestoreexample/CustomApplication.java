package com.inducesmile.firestoreexample;

import android.app.Application;

import com.google.firebase.firestore.FirebaseFirestore;


public class CustomApplication extends Application {

    private static final String TAG = CustomApplication.class.getSimpleName();

    public static CustomApplication instance = null;


    public static CustomApplication getInstance() {
        if (null == instance) {
            instance = new CustomApplication();
        }
        return instance;
    }

    private FirebaseFirestore db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = FirebaseFirestore.getInstance();
    }


    public FirebaseFirestore getDbInstance(){
        return db;
    }
}
