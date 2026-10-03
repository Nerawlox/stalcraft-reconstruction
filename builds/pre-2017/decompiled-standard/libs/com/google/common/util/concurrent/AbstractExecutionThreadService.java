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
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AbstractService(){

        @Override
        protected final void doStart() {
            AbstractExecutionThreadService.this.executor().execute(new Runnable(){

                @Override
                public void run() {
                    try {
                        AbstractExecutionThreadService.this.startUp();
                        this.notifyStarted();
                        if (this.isRunning()) {
                            try {
                                AbstractExecutionThreadService.this.run();
                            }
                            catch (Throwable t) {
                                try {
                                    AbstractExecutionThreadService.this.shutDown();
                                }
                                catch (Exception ignored) {
                                    logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", ignored);
                                }
                                throw t;
                            }
                        }
                        AbstractExecutionThreadService.this.shutDown();
                        this.notifyStopped();
                    }
                    catch (Throwable t) {
                        this.notifyFailed(t);
                        throw Throwables.propagate(t);
                    }
                }
            });
        }

        @Override
        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }
    };

    protected AbstractExecutionThreadService() {
    }

    protected void startUp() throws Exception {
    }

    protected abstract void run() throws Exception;

    protected void shutDown() throws Exception {
    }

    protected void triggerShutdown() {
    }

    protected Executor executor() {
        return new Executor(){

            @Override
            public void execute(Runnable command) {
                MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), command).start();
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

