package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.error.ANError;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface ParsedRequestListener<T> {

    void onResponse(T response);

    void onError(ANError anError);

}