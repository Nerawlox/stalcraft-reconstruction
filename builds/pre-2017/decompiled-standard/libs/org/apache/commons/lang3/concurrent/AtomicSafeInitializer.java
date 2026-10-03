/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AtomicSafeInitializer<T>
implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference();
    private final AtomicReference<T> reference = new AtomicReference();

    @Override
    public final T get() throws ConcurrentException {
        T result2;
        while ((result2 = this.reference.get()) == null) {
            if (!this.factory.compareAndSet(null, this)) continue;
            this.reference.set(this.initialize());
        }
        return result2;
    }

    protected abstract T initialize() throws ConcurrentException;
}

