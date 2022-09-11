

package com.example.rxnetworking.androidnetworking.interfaces;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface AnalyticsListener {

    void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache);

}
