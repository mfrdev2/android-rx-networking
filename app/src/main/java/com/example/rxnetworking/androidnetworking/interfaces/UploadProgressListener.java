

package com.example.rxnetworking.androidnetworking.interfaces;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface UploadProgressListener {
    void onProgress(long bytesUploaded, long totalBytes);
}
