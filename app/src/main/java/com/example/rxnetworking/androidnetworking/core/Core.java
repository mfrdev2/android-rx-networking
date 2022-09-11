

package com.example.rxnetworking.androidnetworking.core;

/**
 * Created by FRabbi on 11/09/22.
 */
public class Core {

    private static Core sInstance = null;
    private final ExecutorSupplier mExecutorSupplier;

    private Core() {
        this.mExecutorSupplier = new DefaultExecutorSupplier();
    }

    public static Core getInstance() {
        if (sInstance == null) {
            synchronized (Core.class) {
                if (sInstance == null) {
                    sInstance = new Core();
                }
            }
        }
        return sInstance;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return mExecutorSupplier;
    }

    public static void shutDown() {
        if (sInstance != null) {
            sInstance = null;
        }
    }
}
