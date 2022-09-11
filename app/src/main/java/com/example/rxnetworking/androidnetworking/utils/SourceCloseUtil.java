package com.example.rxnetworking.androidnetworking.utils;


import com.example.rxnetworking.androidnetworking.common.ANRequest;
import com.example.rxnetworking.androidnetworking.common.ResponseType;

import okhttp3.Response;

/**
 * Created by FRabbi on 11/09/22.
 */
public final class SourceCloseUtil {

    private SourceCloseUtil() {
    }

    public static void close(Response response, ANRequest request) {
        if (request.getResponseAs() != ResponseType.OK_HTTP_RESPONSE &&
                response != null && response.body() != null &&
                response.body().source() != null) {
            try {
                response.body().source().close();
            } catch (Exception ignore) {

            }
        }
    }
}
