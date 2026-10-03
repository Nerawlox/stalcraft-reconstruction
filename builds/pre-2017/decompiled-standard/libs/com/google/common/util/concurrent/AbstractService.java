/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
public abstract class AbstractService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractService.class.getName());
    private final ReentrantLock lock = new ReentrantLock();
    private final Transition startup = new Transition();
    private final Transition shutdown = new Transition();
    @GuardedBy(value="lock")
    private final List<ListenerExecutorPair> listeners = Lists.newArrayList();
    @GuardedBy(value="queuedListeners")
    private final Queue<Runnable> queuedListeners = Queues.newConcurrentLinkedQueue();
    @GuardedBy(value="lock")
    private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);

    protected AbstractService() {
        this.addListener(new Service.Listener(){

            @Override
            public void starting() {
            }

            @Override
            public void running() {
                AbstractService.this.startup.set(Service.State.RUNNING);
            }

            @Override
            public void stopping(Service.State from) {
                if (from == Service.State.STARTING) {
                    AbstractService.this.startup.set(Service.State.STOPPING);
                }
            }

            @Override
            public void terminated(Service.State from) {
                if (from == Service.State.NEW) {
                    AbstractService.this.startup.set(Service.State.TERMINATED);
                }
                AbstractService.this.shutdown.set(Service.State.TERMINATED);
            }

            @Override
            public void failed(Service.State from, Throwable failure) {
                switch (from) {
                    case STARTING: {
                        AbstractService.this.startup.setException(failure);
                        AbstractService.this.shutdown.setException(new Exception("Service failed to start.", failure));
                        break;
                    }
                    case RUNNING: {
                        AbstractService.this.shutdown.setException(new Exception("Service failed while running", failure));
                        break;
                    }
                    case STOPPING: {
                        AbstractService.this.shutdown.setException(failure);
                        break;
                    }
                    default: {
                        throw new AssertionError((Object)("Unexpected from state: " + (Object)((Object)from)));
                    }
                }
            }
        }, MoreExecutors.sameThreadExecutor());
    }

    protected abstract void doStart();

    protected abstract void doStop();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final ListenableFuture<Service.State> start() {
        this.lock.lock();
        try {
            if (this.snapshot.state == Service.State.NEW) {
                this.snapshot = new StateSnapshot(Service.State.STARTING);
                this.starting();
                this.doStart();
            }
        }
        catch (Throwable startupFailure) {
            this.notifyFailed(startupFailure);
        }
        finally {
            this.lock.unlock();
            this.executeListeners();
        }
        return this.startup;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final ListenableFuture<Service.State> stop() {
        this.lock.lock();
        try {
            switch (this.snapshot.state) {
                case NEW: {
                    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                    this.terminated(Service.State.NEW);
                    return this.shutdown;
                }
                case STARTING: {
                    this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);
                    this.stopping(Service.State.STARTING);
                    return this.shutdown;
                }
                case RUNNING: {
                    this.snapshot = new StateSnapshot(Service.State.STOPPING);
                    this.stopping(Service.State.RUNNING);
                    this.doStop();
                    return this.shutdown;
                }
                case STOPPING: 
                case TERMINATED: 
                case FAILED: {
                    return this.shutdown;
                }
                default: {
                    throw new AssertionError((Object)("Unexpected state: " + (Object)((Object)this.snapshot.state)));
                }
            }
        }
        catch (Throwable shutdownFailure) {
            this.notifyFailed(shutdownFailure);
            return this.shutdown;
        }
        finally {
            this.lock.unlock();
            this.executeListeners();
        }
    }

    @Override
    public Service.State startAndWait() {
        return Futures.getUnchecked(this.start());
    }

    @Override
    public Service.State stopAndWait() {
        return Futures.getUnchecked(this.stop());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void notifyStarted() {
        this.lock.lock();
        try {
            if (this.snapshot.state != Service.State.STARTING) {
                IllegalStateException failure = new IllegalStateException("Cannot notifyStarted() when the service is " + (Object)((Object)this.snapshot.state));
                this.notifyFailed(failure);
                throw failure;
            }
            if (this.snapshot.shutdownWhenStartupFinishes) {
                this.snapshot = new StateSnapshot(Service.State.STOPPING);
                this.doStop();
            } else {
                this.snapshot = new StateSnapshot(Service.State.RUNNING);
                this.running();
            }
        }
        finally {
            this.lock.unlock();
            this.executeListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void notifyStopped() {
        this.lock.lock();
        try {
            if (this.snapshot.state != Service.State.STOPPING && this.snapshot.state != Service.State.RUNNING) {
                IllegalStateException failure = new IllegalStateException("Cannot notifyStopped() when the service is " + (Object)((Object)this.snapshot.state));
                this.notifyFailed(failure);
                throw failure;
            }
            Service.State previous = this.snapshot.state;
            this.snapshot = new StateSnapshot(Service.State.TERMINATED);
            this.terminated(previous);
        }
        finally {
            this.lock.unlock();
            this.executeListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final void notifyFailed(Throwable cause) {
        Preconditions.checkNotNull(cause);
        this.lock.lock();
        try {
            switch (this.snapshot.state) {
                case TERMINATED: 
                case NEW: {
                    throw new IllegalStateException("Failed while in state:" + (Object)((Object)this.snapshot.state), cause);
                }
                case STARTING: 
                case RUNNING: 
                case STOPPING: {
                    Service.State previous = this.snapshot.state;
                    this.snapshot = new StateSnapshot(Service.State.FAILED, false, cause);
                    this.failed(previous, cause);
                    return;
                }
                case FAILED: {
                    return;
                }
                default: {
                    throw new AssertionError((Object)("Unexpected state: " + (Object)((Object)this.snapshot.state)));
                }
            }
        }
        finally {
            this.lock.unlock();
            this.executeListeners();
        }
    }

    @Override
    public final boolean isRunning() {
        return this.state() == Service.State.RUNNING;
    }

    @Override
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    @Override
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void addListener(Service.Listener listener, Executor executor) {
        Preconditions.checkNotNull(listener, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.lock.lock();
        try {
            if (this.snapshot.state != Service.State.TERMINATED && this.snapshot.state != Service.State.FAILED) {
                this.listeners.add(new ListenerExecutorPair(listener, executor));
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return this.getClass().getSimpleName() + " [" + (Object)((Object)this.state()) + "]";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void executeListeners() {
        if (!this.lock.isHeldByCurrentThread()) {
            Queue<Runnable> queue = this.queuedListeners;
            synchronized (queue) {
                Runnable listener;
                while ((listener = this.queuedListeners.poll()) != null) {
                    listener.run();
                }
            }
        }
    }

    @GuardedBy(value="lock")
    private void starting() {
        for (final ListenerExecutorPair pair : this.listeners) {
            this.queuedListeners.add(new Runnable(){

                @Override
                public void run() {
                    pair.execute(new Runnable(){

                        @Override
                        public void run() {
                            pair.listener.starting();
                        }
                    });
                }
            });
        }
    }

    @GuardedBy(value="lock")
    private void running() {
        for (final ListenerExecutorPair pair : this.listeners) {
            this.queuedListeners.add(new Runnable(){

                @Override
                public void run() {
                    pair.execute(new Runnable(){

                        @Override
                        public void run() {
                            pair.listener.running();
                        }
                    });
                }
            });
        }
    }

    @GuardedBy(value="lock")
    private void stopping(final Service.State from) {
        for (final ListenerExecutorPair pair : this.listeners) {
            this.queuedListeners.add(new Runnable(){

                @Override
                public void run() {
                    pair.execute(new Runnable(){

                        @Override
                        public void run() {
                            pair.listener.stopping(from);
                        }
                    });
                }
            });
        }
    }

    @GuardedBy(value="lock")
    private void terminated(final Service.State from) {
        for (final ListenerExecutorPair pair : this.listeners) {
            this.queuedListeners.add(new Runnable(){

                @Override
                public void run() {
                    pair.execute(new Runnable(){

                        @Override
                        public void run() {
                            pair.listener.terminated(from);
                        }
                    });
                }
            });
        }
        this.listeners.clear();
    }

    @GuardedBy(value="lock")
    private void failed(final Service.State from, final Throwable cause) {
        for (final ListenerExecutorPair pair : this.listeners) {
            this.queuedListeners.add(new Runnable(){

                @Override
                public void run() {
                    pair.execute(new Runnable(){

                        @Override
                        public void run() {
                            pair.listener.failed(from, cause);
                        }
                    });
                }
            });
        }
        this.listeners.clear();
    }

    @Immutable
    private static final class StateSnapshot {
        final Service.State state;
        final boolean shutdownWhenStartupFinishes;
        @Nullable
        final Throwable failure;

        StateSnapshot(Service.State internalState) {
            this(internalState, false, null);
        }

        StateSnapshot(Service.State internalState, boolean shutdownWhenStartupFinishes, @Nullable Throwable failure) {
            Preconditions.checkArgument(!shutdownWhenStartupFinishes || internalState == Service.State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[]{internalState});
            Preconditions.checkArgument(!(failure != null ^ internalState == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[]{internalState, failure});
            this.state = internalState;
            this.shutdownWhenStartupFinishes = shutdownWhenStartupFinishes;
            this.failure = failure;
        }

        Service.State externalState() {
            if (this.shutdownWhenStartupFinishes && this.state == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.state;
        }

        Throwable failureCause() {
            Preconditions.checkState(this.state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", new Object[]{this.state});
            return this.failure;
        }
    }

    private static class ListenerExecutorPair {
        final Service.Listener listener;
        final Executor executor;

        ListenerExecutorPair(Service.Listener listener, Executor executor) {
            this.listener = listener;
            this.executor = executor;
        }

        void execute(Runnable runnable) {
            try {
                this.executor.execute(runnable);
            }
            catch (Exception e) {
                logger.log(Level.SEVERE, "Exception while executing listener " + this.listener + " with executor " + this.executor, e);
            }
        }
    }

    private class Transition
    extends AbstractFuture<Service.State> {
        private Transition() {
        }

        @Override
        public Service.State get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
            try {
                return (Service.State)((Object)super.get(timeout, unit));
            }
            catch (TimeoutException e) {
                throw new TimeoutException(AbstractService.this.toString());
            }
        }
    }
}

