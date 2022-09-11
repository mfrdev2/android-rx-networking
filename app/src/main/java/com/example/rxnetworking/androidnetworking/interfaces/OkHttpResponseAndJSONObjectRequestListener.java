package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.error.ANError;

import org.json.JSONObject;

import okhttp3.Response;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface OkHttpResponseAndJSONObjectRequestListener {

    void onResponse(Response okHttpResponse, JSONObject response);

    void onError(ANError anError);

}
