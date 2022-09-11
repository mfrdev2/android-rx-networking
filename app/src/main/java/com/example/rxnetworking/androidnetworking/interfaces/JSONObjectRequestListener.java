

package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.error.ANError;

import org.json.JSONObject;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface JSONObjectRequestListener {

    void onResponse(JSONObject response);

    void onError(ANError anError);

}
