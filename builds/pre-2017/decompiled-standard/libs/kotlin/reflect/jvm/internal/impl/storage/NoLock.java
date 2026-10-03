/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.jetbrains.annotations.NotNull;

class NoLock
implements Lock {
    public static final Lock INSTANCE = new NoLock();

    private NoLock() {
    }

    @Override
    public void lock() {
    }

    @Override
    public void unlock() {
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unit", "kotlin/reflect/jvm/internal/impl/storage/NoLock", "tryLock"));
        }
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    @NotNull
    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }
}

