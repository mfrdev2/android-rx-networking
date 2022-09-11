

package com.example.rxnetworking.androidnetworking.core;

import java.util.concurrent.Executor;

/**
 * Created by FRabbi on 11/09/22.
 */
public interface ExecutorSupplier {

    ANExecutor forNetworkTasks();

    ANExecutor forImmediateNetworkTasks();

    Executor forMainThreadTasks();
}
