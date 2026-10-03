/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

@Beta
public interface Service {
    public ListenableFuture<State> start();

    public State startAndWait();

    public boolean isRunning();

    public State state();

    public ListenableFuture<State> stop();

    public State stopAndWait();

    public Throwable failureCause();

    public void addListener(Listener var1, Executor var2);

    @Beta
    public static interface Listener {
        public void starting();

        public void running();

        public void stopping(State var1);

        public void terminated(State var1);

        public void failed(State var1, Throwable var2);
    }

    @Beta
    public static enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED;

    }
}

