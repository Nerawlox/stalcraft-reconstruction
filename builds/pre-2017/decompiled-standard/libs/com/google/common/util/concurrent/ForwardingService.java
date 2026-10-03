/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingObject;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;

@Deprecated
@Beta
public abstract class ForwardingService
extends ForwardingObject
implements Service {
    protected ForwardingService() {
    }

    @Override
    protected abstract Service delegate();

    @Override
    public ListenableFuture<Service.State> start() {
        return this.delegate().start();
    }

    @Override
    public Service.State state() {
        return this.delegate().state();
    }

    @Override
    public ListenableFuture<Service.State> stop() {
        return this.delegate().stop();
    }

    @Override
    public Service.State startAndWait() {
        return this.delegate().startAndWait();
    }

    @Override
    public Service.State stopAndWait() {
        return this.delegate().stopAndWait();
    }

    @Override
    public boolean isRunning() {
        return this.delegate().isRunning();
    }

    @Override
    public void addListener(Service.Listener listener, Executor executor) {
        this.delegate().addListener(listener, executor);
    }

    @Override
    public Throwable failureCause() {
        return this.delegate().failureCause();
    }

    protected Service.State standardStartAndWait() {
        return Futures.getUnchecked(this.start());
    }

    protected Service.State standardStopAndWait() {
        return Futures.getUnchecked(this.stop());
    }
}

