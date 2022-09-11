

package com.example.rxnetworking.androidnetworking.interfaces;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface DownloadProgressListener {
    void onProgress(long bytesDownloaded, long totalBytes);
}
