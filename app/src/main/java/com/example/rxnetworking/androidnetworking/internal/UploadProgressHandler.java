

package com.example.rxnetworking.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.rxnetworking.androidnetworking.common.ANConstants;
import com.example.rxnetworking.androidnetworking.interfaces.UploadProgressListener;
import com.example.rxnetworking.androidnetworking.model.Progress;


/**
 * Created by FRabbi on 11/09/22.
 */
public class UploadProgressHandler extends Handler {

    private final UploadProgressListener mUploadProgressListener;

    public UploadProgressHandler(UploadProgressListener uploadProgressListener) {
        super(Looper.getMainLooper());
        mUploadProgressListener = uploadProgressListener;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ANConstants.UPDATE:
                if (mUploadProgressListener != null) {
                    final Progress progress = (Progress) msg.obj;
                    mUploadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}
