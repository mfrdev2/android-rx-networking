

package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.common.ConnectionQuality;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface ConnectionQualityChangeListener {

    void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth);
}
