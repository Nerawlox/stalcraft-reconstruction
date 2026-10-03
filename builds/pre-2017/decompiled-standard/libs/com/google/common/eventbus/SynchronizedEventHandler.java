/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.EventHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SynchronizedEventHandler
extends EventHandler {
    public SynchronizedEventHandler(Object target, Method method) {
        super(target, method);
    }

    @Override
    public synchronized void handleEvent(Object event) throws InvocationTargetException {
        super.handleEvent(event);
    }
}

