/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;

@Beta
public abstract class AbstractIdleService
implements Service {
    private final Service delegate = new AbstractService(){

        @Override
        protected final void doStart() {
            AbstractIdleService.this.executor().execute(new Runnable(){

                @Override
                public void run() {
                    try {
                        AbstractIdleService.this.startUp();
                        this.notifyStarted();
                    }
                    catch (Throwable t) {
                        this.notifyFailed(t);
                        throw Throwables.propagate(t);
                    }
                }
            });
        }

        @Override
        protected final void doStop() {
            AbstractIdleService.this.executor().execute(new Runnable(){

                @Override
                public void run() {
                    try {
                        AbstractIdleService.this.shutDown();
                        this.notifyStopped();
                    }
                    catch (Throwable t) {
                        this.notifyFailed(t);
                        throw Throwables.propagate(t);
                    }
                }
            });
        }
    };

    protected AbstractIdleService() {
    }

    protected abstract void startUp() throws Exception;

    protected abstract void shutDown() throws Exception;

    protected Executor executor() {
        final Service.State state = this.state();
        return new Executor(){

            @Override
            public void execute(Runnable command) {
                MoreExecutors.newThread(AbstractIdleService.this.serviceName() + " " + (Object)((Object)state), command).start();
            }
        };
    }

    public String toString() {
        return this.serviceName() + " [" + (Object)((Object)this.state()) + "]";
    }

    @Override
    public final ListenableFuture<Service.State> start() {
        return this.delegate.start();
    }

    @Override
    public final Service.State startAndWait() {
        return this.delegate.startAndWait();
    }

    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override
    public final ListenableFuture<Service.State> stop() {
        return this.delegate.stop();
    }

    @Override
    public final Service.State stopAndWait() {
        return this.delegate.stopAndWait();
    }

    @Override
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    protected String serviceName() {
        return this.getClass().getSimpleName();
    }
}

