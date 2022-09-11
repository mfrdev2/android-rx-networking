

package com.example.rxnetworking.androidnetworking.interfaces;

import com.example.rxnetworking.androidnetworking.error.ANError;

import okhttp3.Response;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface OkHttpResponseListener {

    void onResponse(Response response);

    void onError(ANError anError);

}
