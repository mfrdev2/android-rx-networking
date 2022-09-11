
package com.example.rxnetworking.androidnetworking.internal;

import com.example.rxnetworking.androidnetworking.common.ANConstants;
import com.example.rxnetworking.androidnetworking.interfaces.UploadProgressListener;
import com.example.rxnetworking.androidnetworking.model.Progress;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * Created by FRabbi on 11/09/22.
 */
public class RequestProgressBody extends RequestBody {
    private final RequestBody requestBody;
    private BufferedSink bufferedSink;
    private UploadProgressHandler uploadProgressHandler;

    public RequestProgressBody(RequestBody requestBody, UploadProgressListener uploadProgressListener) {
        this.requestBody = requestBody;
        if (uploadProgressListener != null) {
            this.uploadProgressHandler = new UploadProgressHandler(uploadProgressListener);
        }
    }

    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if (bufferedSink == null) {
            bufferedSink = Okio.buffer(sink(sink));
        }
        requestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) {
            long bytesWritten = 0L;
            long contentLength = 0L;

            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                if (contentLength == 0) {
                    contentLength = contentLength();
                }
                bytesWritten += byteCount;
                if (uploadProgressHandler != null) {
                    uploadProgressHandler.obtainMessage(ANConstants.UPDATE,
                            new Progress(bytesWritten, contentLength)).sendToTarget();
                }
            }
        };
    }
}