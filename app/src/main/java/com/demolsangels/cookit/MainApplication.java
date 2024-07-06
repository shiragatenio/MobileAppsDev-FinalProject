package com.demolsangels.cookit;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class MainApplication extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        // Initialize Firebase Analytics
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);

        // Initialize Firebase Crashlytics
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
    }
}
