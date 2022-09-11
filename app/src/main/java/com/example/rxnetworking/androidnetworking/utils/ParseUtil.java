

package com.example.rxnetworking.androidnetworking.utils;


import com.example.rxnetworking.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.example.rxnetworking.androidnetworking.interfaces.Parser;
import com.google.gson.Gson;

/**
 * Created by FRabbi on 11/09/22.
 */
public class ParseUtil {

    private static Parser.Factory mParserFactory;

    public static void setParserFactory(Parser.Factory parserFactory) {
        mParserFactory = parserFactory;
    }

    public static Parser.Factory getParserFactory() {
        if (mParserFactory == null) {
            mParserFactory = new GsonParserFactory(new Gson());
        }
        return mParserFactory;
    }

    public static void shutDown() {
        mParserFactory = null;
    }

}
