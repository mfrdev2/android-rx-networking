

package com.example.rxnetworking.androidnetworking.interfaces;

import android.graphics.Bitmap;

import com.example.rxnetworking.androidnetworking.error.ANError;

import okhttp3.Response;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface OkHttpResponseAndBitmapRequestListener {

    void onResponse(Response okHttpResponse, Bitmap response);

    void onError(ANError anError);

}
