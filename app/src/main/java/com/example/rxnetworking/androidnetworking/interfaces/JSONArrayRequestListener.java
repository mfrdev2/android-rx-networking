

package com.example.rxnetworking.androidnetworking.interfaces;


import com.example.rxnetworking.androidnetworking.error.ANError;

import org.json.JSONArray;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface JSONArrayRequestListener {

    void onResponse(JSONArray response);

    void onError(ANError anError);

}
