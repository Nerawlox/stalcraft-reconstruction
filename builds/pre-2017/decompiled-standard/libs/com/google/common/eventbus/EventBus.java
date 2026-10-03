/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.eventbus.AnnotatedHandlerFinder;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventHandler;
import com.google.common.eventbus.HandlerFindingStrategy;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
    private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, Set<Class<?>>>(){

        @Override
        public Set<Class<?>> load(Class<?> concreteClass) {
            return TypeToken.of(concreteClass).getTypes().rawTypes();
        }
    });
    private final SetMultimap<Class<?>, EventHandler> handlersByType = HashMultimap.create();
    private final ReadWriteLock handlersByTypeLock = new ReentrantReadWriteLock();
    private final Logger logger;
    private final HandlerFindingStrategy finder = new AnnotatedHandlerFinder();
    private final ThreadLocal<Queue<EventWithHandler>> eventsToDispatch = new ThreadLocal<Queue<EventWithHandler>>(){

        @Override
        protected Queue<EventWithHandler> initialValue() {
            return new LinkedList<EventWithHandler>();
        }
    };
    private final ThreadLocal<Boolean> isDispatching = new ThreadLocal<Boolean>(){

        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    public EventBus() {
        this("default");
    }

    public EventBus(String identifier) {
        this.logger = Logger.getLogger(EventBus.class.getName() + "." + Preconditions.checkNotNull(identifier));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void register(Object object) {
        Multimap<Class<?>, EventHandler> methodsInListener = this.finder.findAllHandlers(object);
        this.handlersByTypeLock.writeLock().lock();
        try {
            this.handlersByType.putAll(methodsInListener);
        }
        finally {
            this.handlersByTypeLock.writeLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregister(Object object) {
        Multimap<Class<?>, EventHandler> methodsInListener = this.finder.findAllHandlers(object);
        for (Map.Entry<Class<?>, Collection<EventHandler>> entry : methodsInListener.asMap().entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<EventHandler> eventMethodsInListener = entry.getValue();
            this.handlersByTypeLock.writeLock().lock();
            try {
                Set<EventHandler> currentHandlers = this.handlersByType.get(eventType);
                if (!currentHandlers.containsAll(eventMethodsInListener)) {
                    throw new IllegalArgumentException("missing event handler for an annotated method. Is " + object + " registered?");
                }
                currentHandlers.removeAll(eventMethodsInListener);
            }
            finally {
                this.handlersByTypeLock.writeLock().unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void post(Object event) {
        Set<Class<?>> dispatchTypes = this.flattenHierarchy(event.getClass());
        boolean dispatched = false;
        for (Class<?> eventType : dispatchTypes) {
            this.handlersByTypeLock.readLock().lock();
            try {
                Set<EventHandler> wrappers = this.handlersByType.get(eventType);
                if (wrappers.isEmpty()) continue;
                dispatched = true;
                for (EventHandler wrapper : wrappers) {
                    this.enqueueEvent(event, wrapper);
                }
            }
            finally {
                this.handlersByTypeLock.readLock().unlock();
            }
        }
        if (!dispatched && !(event instanceof DeadEvent)) {
            this.post(new DeadEvent(this, event));
        }
        this.dispatchQueuedEvents();
    }

    void enqueueEvent(Object event, EventHandler handler) {
        this.eventsToDispatch.get().offer(new EventWithHandler(event, handler));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void dispatchQueuedEvents() {
        if (this.isDispatching.get().booleanValue()) {
            return;
        }
        this.isDispatching.set(true);
        try {
            EventWithHandler eventWithHandler;
            Queue<EventWithHandler> events = this.eventsToDispatch.get();
            while ((eventWithHandler = events.poll()) != null) {
                this.dispatch(eventWithHandler.event, eventWithHandler.handler);
            }
        }
        finally {
            this.isDispatching.remove();
        }
    }

    void dispatch(Object event, EventHandler wrapper) {
        try {
            wrapper.handleEvent(event);
        }
        catch (InvocationTargetException e) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + event + " to handler " + wrapper, e);
        }
    }

    @VisibleForTesting
    Set<Class<?>> flattenHierarchy(Class<?> concreteClass) {
        try {
            return flattenHierarchyCache.getUnchecked(concreteClass);
        }
        catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    static class EventWithHandler {
        final Object event;
        final EventHandler handler;

        public EventWithHandler(Object event, EventHandler handler) {
            this.event = Preconditions.checkNotNull(event);
            this.handler = Preconditions.checkNotNull(handler);
        }
    }
}

