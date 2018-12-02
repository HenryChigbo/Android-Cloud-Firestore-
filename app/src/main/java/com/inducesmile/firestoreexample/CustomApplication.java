package com.inducesmile.firestoreexample;

import android.app.Application;

import com.google.firebase.firestore.FirebaseFirestore;

public class CustomApplication extends Application {

    private static final String TAG = CustomApplication.class.getSimpleName();

    private FirebaseFirestore db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = FirebaseFirestore.getInstance();
    }
}
