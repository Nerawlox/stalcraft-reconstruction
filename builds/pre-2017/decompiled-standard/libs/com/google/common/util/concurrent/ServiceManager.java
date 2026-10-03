/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 *  javax.annotation.concurrent.Immutable
 *  javax.inject.Inject
 *  javax.inject.Singleton
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Beta
public final class ServiceManager {
    private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private final ServiceManagerState state;
    private final ImmutableMap<Service, ServiceListener> services;

    public ServiceManager(Iterable<? extends Service> services) {
        ImmutableList<? extends Service> copy = ImmutableList.copyOf(services);
        this.state = new ServiceManagerState(copy.size());
        ImmutableMap.Builder<Service, ServiceListener> builder = ImmutableMap.builder();
        ListeningExecutorService executor = MoreExecutors.sameThreadExecutor();
        for (Service service : copy) {
            ServiceListener listener = new ServiceListener(service, this.state);
            service.addListener(listener, executor);
            Preconditions.checkArgument(service.state() == Service.State.NEW, "Can only manage NEW services, %s", service);
            builder.put(service, listener);
        }
        this.services = builder.build();
    }

    @Inject
    ServiceManager(Set<Service> services) {
        this((Iterable<? extends Service>)services);
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.addListener(listener, executor);
    }

    public ServiceManager startAsync() {
        for (Map.Entry entry : this.services.entrySet()) {
            Service service = (Service)entry.getKey();
            Service.State state = service.state();
            Preconditions.checkState(state == Service.State.NEW, "Service %s is %s, cannot start it.", new Object[]{service, state});
        }
        for (ServiceListener service : this.services.values()) {
            service.start();
        }
        return this;
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
        Preconditions.checkState(this.isHealthy(), "Expected to be healthy after starting");
    }

    public void awaitHealthy(long timeout, TimeUnit unit) throws TimeoutException {
        if (!this.state.awaitHealthy(timeout, unit)) {
            throw new TimeoutException("Timeout waiting for the services to become healthy.");
        }
        Preconditions.checkState(this.isHealthy(), "Expected to be healthy after starting");
    }

    public ServiceManager stopAsync() {
        for (Service service : this.services.keySet()) {
            service.stop();
        }
        return this;
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public void awaitStopped(long timeout, TimeUnit unit) throws TimeoutException {
        if (!this.state.awaitStopped(timeout, unit)) {
            throw new TimeoutException("Timeout waiting for the services to stop.");
        }
    }

    public boolean isHealthy() {
        for (Service service : this.services.keySet()) {
            if (service.isRunning()) continue;
            return false;
        }
        return true;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        ImmutableMultimap.Builder<Service.State, Service> builder = ImmutableMultimap.builder();
        for (Service service : this.services.keySet()) {
            builder.put(service.state(), service);
        }
        return builder.build();
    }

    public ImmutableMap<Service, Long> startupTimes() {
        HashMap loadTimeMap = Maps.newHashMapWithExpectedSize(this.services.size());
        for (Map.Entry entry : this.services.entrySet()) {
            Service.State state = ((Service)entry.getKey()).state();
            if (state == Service.State.NEW || state == Service.State.STARTING) continue;
            loadTimeMap.put(entry.getKey(), ((ServiceListener)entry.getValue()).startupTimeMillis());
        }
        List servicesByStartTime = Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>(){

            @Override
            public Long apply(Map.Entry<Service, Long> input) {
                return input.getValue();
            }
        }).sortedCopy(loadTimeMap.entrySet());
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (Map.Entry entry : servicesByStartTime) {
            builder.put(entry);
        }
        return builder.build();
    }

    public String toString() {
        return Objects.toStringHelper(ServiceManager.class).add("services", this.services.keySet()).toString();
    }

    @Immutable
    private static final class ListenerExecutorPair {
        final Listener listener;
        final Executor executor;

        ListenerExecutorPair(Listener listener, Executor executor) {
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

    private static final class ServiceListener
    implements Service.Listener {
        @GuardedBy(value="watch")
        final Stopwatch watch = new Stopwatch();
        final Service service;
        final ServiceManagerState state;

        ServiceListener(Service service, ServiceManagerState state) {
            this.service = service;
            this.state = state;
        }

        @Override
        public void starting() {
            this.startTimer();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void running() {
            this.state.monitor.enter();
            try {
                this.finishedStarting(true);
            }
            finally {
                this.state.monitor.leave();
                this.state.executeListeners();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void stopping(Service.State from) {
            if (from == Service.State.STARTING) {
                this.state.monitor.enter();
                try {
                    this.finishedStarting(false);
                }
                finally {
                    this.state.monitor.leave();
                    this.state.executeListeners();
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void terminated(Service.State from) {
            logger.info("Service " + this.service + " has terminated. Previous state was " + (Object)((Object)from) + " state.");
            this.state.monitor.enter();
            try {
                if (from == Service.State.NEW) {
                    this.startTimer();
                    this.finishedStarting(false);
                }
                this.state.serviceTerminated(this.service);
            }
            finally {
                this.state.monitor.leave();
                this.state.executeListeners();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void failed(Service.State from, Throwable failure) {
            logger.log(Level.SEVERE, "Service " + this.service + " has failed in the " + (Object)((Object)from) + " state.", failure);
            this.state.monitor.enter();
            try {
                if (from == Service.State.STARTING) {
                    this.finishedStarting(false);
                }
                this.state.serviceFailed(this.service);
            }
            finally {
                this.state.monitor.leave();
                this.state.executeListeners();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @GuardedBy(value="monitor")
        void finishedStarting(boolean currentlyHealthy) {
            Stopwatch stopwatch = this.watch;
            synchronized (stopwatch) {
                this.watch.stop();
                logger.log(Level.INFO, "Started " + this.service + " in " + this.startupTimeMillis() + " ms.");
            }
            this.state.serviceFinishedStarting(this.service, currentlyHealthy);
        }

        void start() {
            this.startTimer();
            this.service.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void startTimer() {
            Stopwatch stopwatch = this.watch;
            synchronized (stopwatch) {
                if (!this.watch.isRunning()) {
                    this.watch.start();
                    logger.log(Level.INFO, "Starting {0}", this.service);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        synchronized long startupTimeMillis() {
            Stopwatch stopwatch = this.watch;
            synchronized (stopwatch) {
                return this.watch.elapsed(TimeUnit.MILLISECONDS);
            }
        }
    }

    private static final class ServiceManagerState {
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        @GuardedBy(value="monitor")
        int unstartedServices;
        @GuardedBy(value="monitor")
        int unstoppedServices;
        final Monitor.Guard awaitHealthGuard = new Monitor.Guard(this.monitor){

            @Override
            public boolean isSatisfied() {
                return ServiceManagerState.this.unstartedServices == 0 || ServiceManagerState.this.unstoppedServices != ServiceManagerState.this.numberOfServices;
            }
        };
        final Monitor.Guard stoppedGuard = new Monitor.Guard(this.monitor){

            @Override
            public boolean isSatisfied() {
                return ServiceManagerState.this.unstoppedServices == 0;
            }
        };
        @GuardedBy(value="monitor")
        final List<ListenerExecutorPair> listeners = Lists.newArrayList();
        @GuardedBy(value="queuedListeners")
        final Queue<Runnable> queuedListeners = Queues.newConcurrentLinkedQueue();

        ServiceManagerState(int numberOfServices) {
            this.numberOfServices = numberOfServices;
            this.unstoppedServices = numberOfServices;
            this.unstartedServices = numberOfServices;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void addListener(Listener listener, Executor executor) {
            Preconditions.checkNotNull(listener, "listener");
            Preconditions.checkNotNull(executor, "executor");
            this.monitor.enter();
            try {
                if (this.unstartedServices > 0 || this.unstoppedServices > 0) {
                    this.listeners.add(new ListenerExecutorPair(listener, executor));
                }
            }
            finally {
                this.monitor.leave();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void awaitHealthy() {
            this.monitor.enter();
            try {
                this.monitor.waitForUninterruptibly(this.awaitHealthGuard);
            }
            finally {
                this.monitor.leave();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean awaitHealthy(long timeout, TimeUnit unit) {
            this.monitor.enter();
            try {
                if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, timeout, unit)) {
                    boolean bl = true;
                    return bl;
                }
                boolean bl = false;
                return bl;
            }
            finally {
                this.monitor.leave();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void awaitStopped() {
            this.monitor.enter();
            try {
                this.monitor.waitForUninterruptibly(this.stoppedGuard);
            }
            finally {
                this.monitor.leave();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean awaitStopped(long timeout, TimeUnit unit) {
            this.monitor.enter();
            try {
                boolean bl = this.monitor.waitForUninterruptibly(this.stoppedGuard, timeout, unit);
                return bl;
            }
            finally {
                this.monitor.leave();
            }
        }

        @GuardedBy(value="monitor")
        private void serviceFinishedStarting(Service service, boolean currentlyHealthy) {
            Preconditions.checkState(this.unstartedServices > 0, "All services should have already finished starting but %s just finished.", service);
            --this.unstartedServices;
            if (currentlyHealthy && this.unstartedServices == 0 && this.unstoppedServices == this.numberOfServices) {
                for (final ListenerExecutorPair pair : this.listeners) {
                    this.queuedListeners.add(new Runnable(){

                        @Override
                        public void run() {
                            pair.execute(new Runnable(){

                                @Override
                                public void run() {
                                    pair.listener.healthy();
                                }
                            });
                        }
                    });
                }
            }
        }

        @GuardedBy(value="monitor")
        private void serviceTerminated(Service service) {
            this.serviceStopped(service);
        }

        @GuardedBy(value="monitor")
        private void serviceFailed(final Service service) {
            for (final ListenerExecutorPair pair : this.listeners) {
                this.queuedListeners.add(new Runnable(){

                    @Override
                    public void run() {
                        pair.execute(new Runnable(){

                            @Override
                            public void run() {
                                pair.listener.failure(service);
                            }
                        });
                    }
                });
            }
            this.serviceStopped(service);
        }

        @GuardedBy(value="monitor")
        private void serviceStopped(Service service) {
            Preconditions.checkState(this.unstoppedServices > 0, "All services should have already stopped but %s just stopped.", service);
            --this.unstoppedServices;
            if (this.unstoppedServices == 0) {
                Preconditions.checkState(this.unstartedServices == 0, "All services are stopped but %d services haven't finished starting", this.unstartedServices);
                for (final ListenerExecutorPair pair : this.listeners) {
                    this.queuedListeners.add(new Runnable(){

                        @Override
                        public void run() {
                            pair.execute(new Runnable(){

                                @Override
                                public void run() {
                                    pair.listener.stopped();
                                }
                            });
                        }
                    });
                }
                this.listeners.clear();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void executeListeners() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            Queue<Runnable> queue = this.queuedListeners;
            synchronized (queue) {
                Runnable listener;
                while ((listener = this.queuedListeners.poll()) != null) {
                    listener.run();
                }
            }
        }
    }

    @Beta
    public static interface Listener {
        public void healthy();

        public void stopped();

        public void failure(Service var1);
    }
}

