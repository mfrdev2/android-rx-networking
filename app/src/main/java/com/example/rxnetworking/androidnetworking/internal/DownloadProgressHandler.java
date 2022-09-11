

package com.example.rxnetworking.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.rxnetworking.androidnetworking.common.ANConstants;
import com.example.rxnetworking.androidnetworking.interfaces.DownloadProgressListener;
import com.example.rxnetworking.androidnetworking.model.Progress;

/**
 * Created by FRabbi on 11/09/22.
 */
public class DownloadProgressHandler extends Handler {

    private final DownloadProgressListener mDownloadProgressListener;

    public DownloadProgressHandler(DownloadProgressListener downloadProgressListener) {
        super(Looper.getMainLooper());
        mDownloadProgressListener = downloadProgressListener;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ANConstants.UPDATE:
                if (mDownloadProgressListener != null) {
                    final Progress progress = (Progress) msg.obj;
                    mDownloadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}
