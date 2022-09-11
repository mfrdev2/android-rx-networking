package com.example.rxnetworking;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.example.rxnetworking.androidnetworking.AndroidNetworking;
import com.example.rxnetworking.androidnetworking.common.ConnectionQuality;
import com.example.rxnetworking.androidnetworking.interfaces.ConnectionQualityChangeListener;

public class MyApp extends Application {
    private static final String TAG = MyApp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.enableLogging();
        AndroidNetworking.setConnectionQualityChangeListener(new ConnectionQualityChangeListener() {
            @Override
            public void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth) {
                Log.d(TAG, "onChange: currentConnectionQuality : " + currentConnectionQuality + " currentBandwidth : " + currentBandwidth);
            }
        });
        getCurrentConnectionQuality(null);
    }

    public void getCurrentConnectionQuality(View view) {
        Log.d(TAG, "getCurrentConnectionQuality : " + AndroidNetworking.getCurrentConnectionQuality() + " currentBandwidth : " + AndroidNetworking.getCurrentBandwidth());
    }
}
