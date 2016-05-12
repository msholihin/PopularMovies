package com.msholihin.popularmovies.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by sholihin on 11/05/16.
 */
public class MovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
