/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;
import org.apache.commons.lang3.concurrent.ConcurrentRuntimeException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ConcurrentUtils {
    private ConcurrentUtils() {
    }

    public static ConcurrentException extractCause(ExecutionException ex) {
        if (ex == null || ex.getCause() == null) {
            return null;
        }
        ConcurrentUtils.throwCause(ex);
        return new ConcurrentException(ex.getMessage(), ex.getCause());
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException ex) {
        if (ex == null || ex.getCause() == null) {
            return null;
        }
        ConcurrentUtils.throwCause(ex);
        return new ConcurrentRuntimeException(ex.getMessage(), ex.getCause());
    }

    public static void handleCause(ExecutionException ex) throws ConcurrentException {
        ConcurrentException cex = ConcurrentUtils.extractCause(ex);
        if (cex != null) {
            throw cex;
        }
    }

    public static void handleCauseUnchecked(ExecutionException ex) {
        ConcurrentRuntimeException crex = ConcurrentUtils.extractCauseUnchecked(ex);
        if (crex != null) {
            throw crex;
        }
    }

    static Throwable checkedException(Throwable ex) {
        if (ex != null && !(ex instanceof RuntimeException) && !(ex instanceof Error)) {
            return ex;
        }
        throw new IllegalArgumentException("Not a checked exception: " + ex);
    }

    private static void throwCause(ExecutionException ex) {
        if (ex.getCause() instanceof RuntimeException) {
            throw (RuntimeException)ex.getCause();
        }
        if (ex.getCause() instanceof Error) {
            throw (Error)ex.getCause();
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> initializer2) throws ConcurrentException {
        return initializer2 != null ? (T)initializer2.get() : null;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> initializer2) {
        try {
            return ConcurrentUtils.initialize(initializer2);
        }
        catch (ConcurrentException cex) {
            throw new ConcurrentRuntimeException(cex.getCause());
        }
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> map2, K key, V value) {
        if (map2 == null) {
            return null;
        }
        V result2 = map2.putIfAbsent(key, value);
        return result2 != null ? result2 : value;
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> map2, K key, ConcurrentInitializer<V> init) throws ConcurrentException {
        if (map2 == null || init == null) {
            return null;
        }
        Object value = map2.get(key);
        if (value == null) {
            return ConcurrentUtils.putIfAbsent(map2, key, init.get());
        }
        return value;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> map2, K key, ConcurrentInitializer<V> init) {
        try {
            return ConcurrentUtils.createIfAbsent(map2, key, init);
        }
        catch (ConcurrentException cex) {
            throw new ConcurrentRuntimeException(cex.getCause());
        }
    }

    public static <T> Future<T> constantFuture(T value) {
        return new ConstantFuture<T>(value);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class ConstantFuture<T>
    implements Future<T> {
        private final T value;

        ConstantFuture(T value) {
            this.value = value;
        }

        @Override
        public boolean isDone() {
            return true;
        }

        @Override
        public T get() {
            return this.value;
        }

        @Override
        public T get(long timeout, TimeUnit unit) {
            return this.value;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }
    }
}

