

package com.example.rxnetworking.androidnetworking.interfaces;

import android.graphics.Bitmap;

import com.example.rxnetworking.androidnetworking.error.ANError;


/**
 * Created by FRabbi on 11/09/22.
 */
public interface BitmapRequestListener {

    void onResponse(Bitmap response);

    void onError(ANError anError);

}
