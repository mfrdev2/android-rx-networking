
package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.error.ANError;

import okhttp3.Response;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface OkHttpResponseAndStringRequestListener {

    void onResponse(Response okHttpResponse, String response);

    void onError(ANError anError);

}
