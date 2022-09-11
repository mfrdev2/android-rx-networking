

package com.example.rxnetworking.androidnetworking.model;

import java.io.Serializable;

/**
 * Created by FRabbi on 11/09/22.
 */

public class Progress implements Serializable {

    public long currentBytes;
    public long totalBytes;

    public Progress(long currentBytes, long totalBytes) {
        this.currentBytes = currentBytes;
        this.totalBytes = totalBytes;
    }

}