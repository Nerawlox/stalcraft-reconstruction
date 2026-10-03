/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
implements ThreadFactory {
    private String _prefix;
    private ThreadGroup _group;
    private int _priority;
    private boolean _isDaemon;
    private AtomicInteger _counter = new AtomicInteger(0);

    public NamedThreadFactory(String string) {
        this(string, Thread.currentThread().getThreadGroup(), 5, true);
    }

    public NamedThreadFactory(String string, ThreadGroup threadGroup, int n, boolean bl) {
        this._prefix = string;
        this._group = threadGroup;
        this._priority = n;
        this._isDaemon = bl;
    }

    public Thread newThread(Runnable runnable) {
        String string = this._prefix + "-thread-" + this._counter.getAndIncrement();
        Thread thread = new Thread(this._group, runnable, string);
        thread.setPriority(this._priority);
        thread.setDaemon(this._isDaemon);
        return thread;
    }
}

