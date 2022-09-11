package com.example.rxnetworking.androidnetworking;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.example.rxnetworking.androidnetworking.common.ANConstants;
import com.example.rxnetworking.androidnetworking.common.ANRequest;
import com.example.rxnetworking.androidnetworking.common.ConnectionClassManager;
import com.example.rxnetworking.androidnetworking.common.ConnectionQuality;
import com.example.rxnetworking.androidnetworking.core.Core;
import com.example.rxnetworking.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.example.rxnetworking.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.example.rxnetworking.androidnetworking.interfaces.Parser;
import com.example.rxnetworking.androidnetworking.internal.ANImageLoader;
import com.example.rxnetworking.androidnetworking.internal.ANRequestQueue;
import com.example.rxnetworking.androidnetworking.internal.InternalNetworking;
import com.example.rxnetworking.androidnetworking.utils.ParseUtil;
import com.example.rxnetworking.androidnetworking.utils.Utils;

import okhttp3.OkHttpClient;

/**
 * Created by FRabbi on 11/09/22.
 */

/**
 * AndroidNetworking entry point.
 * You must initialize this class before use. The simplest way is to just do
 * {#code AndroidNetworking.initialize(context)}.
 */
@SuppressWarnings("unused")
public class AndroidNetworking {

    /**
     * private constructor to prevent instantiation of this class
     */
    private AndroidNetworking() {
    }

    /**
     * Initializes AndroidNetworking with the default config.
     *
     * @param context The context
     */
    public static void initialize(Context context) {
        InternalNetworking.setClientWithCache(context.getApplicationContext());
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    /**
     * Initializes AndroidNetworking with the specified config.
     *
     * @param context      The context
     * @param okHttpClient The okHttpClient
     */
    public static void initialize(Context context, OkHttpClient okHttpClient) {
        if (okHttpClient != null && okHttpClient.cache() == null) {
            okHttpClient = okHttpClient
                    .newBuilder()
                    .cache(Utils.getCache(context.getApplicationContext(),
                            ANConstants.MAX_CACHE_SIZE, ANConstants.CACHE_DIR_NAME))
                    .build();
        }
        InternalNetworking.setClient(okHttpClient);
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    /**
     * Method to set decodeOptions
     *
     * @param decodeOptions The decode config for Bitmaps
     */
    public static void setBitmapDecodeOptions(BitmapFactory.Options decodeOptions) {
        if (decodeOptions != null) {
            ANImageLoader.getInstance().setBitmapDecodeOptions(decodeOptions);
        }
    }

    /**
     * Method to set connectionQualityChangeListener
     *
     * @param connectionChangeListener The connectionQualityChangeListener
     */
    public static void setConnectionQualityChangeListener(ConnectionQualityChangeListener connectionChangeListener) {
        ConnectionClassManager.getInstance().setListener(connectionChangeListener);
    }

    /**
     * Method to set connectionQualityChangeListener
     */
    public static void removeConnectionQualityChangeListener() {
        ConnectionClassManager.getInstance().removeListener();
    }

    /**
     * Method to make GET request
     *
     * @param url The url on which request is to be made
     * @return The GetRequestBuilder
     */
    public static ANRequest.GetRequestBuilder get(String url) {
        return new ANRequest.GetRequestBuilder(url);
    }

    /**
     * Method to make HEAD request
     *
     * @param url The url on which request is to be made
     * @return The HeadRequestBuilder
     */
    public static ANRequest.HeadRequestBuilder head(String url) {
        return new ANRequest.HeadRequestBuilder(url);
    }

    /**
     * Method to make OPTIONS request
     *
     * @param url The url on which request is to be made
     * @return The OptionsRequestBuilder
     */
    public static ANRequest.OptionsRequestBuilder options(String url) {
        return new ANRequest.OptionsRequestBuilder(url);
    }

    /**
     * Method to make POST request
     *
     * @param url The url on which request is to be made
     * @return The PostRequestBuilder
     */
    public static ANRequest.PostRequestBuilder post(String url) {
        return new ANRequest.PostRequestBuilder(url);
    }

    /**
     * Method to make PUT request
     *
     * @param url The url on which request is to be made
     * @return The PutRequestBuilder
     */
    public static ANRequest.PutRequestBuilder put(String url) {
        return new ANRequest.PutRequestBuilder(url);
    }

    /**
     * Method to make DELETE request
     *
     * @param url The url on which request is to be made
     * @return The DeleteRequestBuilder
     */
    public static ANRequest.DeleteRequestBuilder delete(String url) {
        return new ANRequest.DeleteRequestBuilder(url);
    }

    /**
     * Method to make PATCH request
     *
     * @param url The url on which request is to be made
     * @return The PatchRequestBuilder
     */
    public static ANRequest.PatchRequestBuilder patch(String url) {
        return new ANRequest.PatchRequestBuilder(url);
    }

    /**
     * Method to make download request
     *
     * @param url      The url on which request is to be made
     * @param dirPath  The directory path on which file is to be saved
     * @param fileName The file name with which file is to be saved
     * @return The DownloadBuilder
     */
    public static ANRequest.DownloadBuilder download(String url, String dirPath, String fileName) {
        return new ANRequest.DownloadBuilder(url, dirPath, fileName);
    }

    /**
     * Method to make upload request
     *
     * @param url The url on which request is to be made
     * @return The MultiPartBuilder
     */
    public static ANRequest.MultiPartBuilder upload(String url) {
        return new ANRequest.MultiPartBuilder(url);
    }

    /**
     * Method to make Dynamic request
     *
     * @param url    The url on which request is to be made
     * @param method The HTTP METHOD for the request
     * @return The DynamicRequestBuilder
     */
    public static ANRequest.DynamicRequestBuilder request(String url, int method) {
        return new ANRequest.DynamicRequestBuilder(url, method);
    }

    /**
     * Method to cancel requests with the given tag
     *
     * @param tag The tag with which requests are to be cancelled
     */
    public static void cancel(Object tag) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(tag, false);
    }

    /**
     * Method to force cancel requests with the given tag
     *
     * @param tag The tag with which requests are to be cancelled
     */
    public static void forceCancel(Object tag) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(tag, true);
    }

    /**
     * Method to cancel all given request
     */
    public static void cancelAll() {
        ANRequestQueue.getInstance().cancelAll(false);
    }

    /**
     * Method to force cancel all given request
     */
    public static void forceCancelAll() {
        ANRequestQueue.getInstance().cancelAll(true);
    }

    /**
     * Method to enable logging
     */
    public static void enableLogging() {
        enableLogging(HttpLoggingInterceptor.Level.BASIC);
    }

    /**
     * Method to enable logging with tag
     *
     * @param level The level for logging
     */
    public static void enableLogging(HttpLoggingInterceptor.Level level) {
        InternalNetworking.enableLogging(level);
    }

    /**
     * Method to evict a bitmap with given key from LruCache
     *
     * @param key The key of the bitmap
     */
    public static void evictBitmap(String key) {
        final ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null && key != null) {
            imageCache.evictBitmap(key);
        }
    }

    /**
     * Method to clear LruCache
     */
    public static void evictAllBitmap() {
        final ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null) {
            imageCache.evictAllBitmap();
        }
    }

    /**
     * Method to set userAgent globally
     *
     * @param userAgent The userAgent
     */
    public static void setUserAgent(String userAgent) {
        InternalNetworking.setUserAgent(userAgent);
    }

    /**
     * Method to get currentBandwidth
     *
     * @return currentBandwidth
     */
    public static int getCurrentBandwidth() {
        return ConnectionClassManager.getInstance().getCurrentBandwidth();
    }

    /**
     * Method to get currentConnectionQuality
     *
     * @return currentConnectionQuality
     */
    public static ConnectionQuality getCurrentConnectionQuality() {
        return ConnectionClassManager.getInstance().getCurrentConnectionQuality();
    }

    /**
     * Method to set ParserFactory
     *
     * @param parserFactory The ParserFactory
     */
    public static void setParserFactory(Parser.Factory parserFactory) {
        ParseUtil.setParserFactory(parserFactory);
    }

    /**
     * Method to find if the request is running or not
     *
     * @param tag The tag with which request running status is to be checked
     * @return The request is running or not
     */
    public static boolean isRequestRunning(Object tag) {
        return ANRequestQueue.getInstance().isRequestRunning(tag);
    }

    /**
     * Shuts AndroidNetworking down
     */
    public static void shutDown() {
        Core.shutDown();
        evictAllBitmap();
        ConnectionClassManager.getInstance().removeListener();
        ConnectionClassManager.shutDown();
        ParseUtil.shutDown();
    }
}
