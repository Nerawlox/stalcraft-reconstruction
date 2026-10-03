/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventHandler;
import com.google.common.eventbus.HandlerFindingStrategy;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.SynchronizedEventHandler;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.Set;

class AnnotatedHandlerFinder
implements HandlerFindingStrategy {
    private static final LoadingCache<Class<?>, ImmutableList<Method>> handlerMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>(){

        @Override
        public ImmutableList<Method> load(Class<?> concreteClass) throws Exception {
            return AnnotatedHandlerFinder.getAnnotatedMethodsInternal(concreteClass);
        }
    });

    AnnotatedHandlerFinder() {
    }

    @Override
    public Multimap<Class<?>, EventHandler> findAllHandlers(Object listener) {
        HashMultimap<Class<?>, EventHandler> methodsInListener = HashMultimap.create();
        Class<?> clazz = listener.getClass();
        for (Method method : AnnotatedHandlerFinder.getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            EventHandler handler = AnnotatedHandlerFinder.makeHandler(listener, method);
            methodsInListener.put(eventType, handler);
        }
        return methodsInListener;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> clazz) {
        try {
            return handlerMethodsCache.getUnchecked(clazz);
        }
        catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    private static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> clazz) {
        Set supers = TypeToken.of(clazz).getTypes().rawTypes();
        ImmutableList.Builder result2 = ImmutableList.builder();
        block2: for (Method method : clazz.getMethods()) {
            for (Class c : supers) {
                try {
                    Method m = c.getMethod(method.getName(), method.getParameterTypes());
                    if (!m.isAnnotationPresent(Subscribe.class)) continue;
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation, but requires " + parameterTypes.length + " arguments.  Event handler methods must require a single argument.");
                    }
                    Class<?> eventType = parameterTypes[0];
                    result2.add(method);
                    continue block2;
                }
                catch (NoSuchMethodException ignored) {
                }
            }
        }
        return result2.build();
    }

    private static EventHandler makeHandler(Object listener, Method method) {
        EventHandler wrapper = AnnotatedHandlerFinder.methodIsDeclaredThreadSafe(method) ? new EventHandler(listener, method) : new SynchronizedEventHandler(listener, method);
        return wrapper;
    }

    private static boolean methodIsDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }
}

