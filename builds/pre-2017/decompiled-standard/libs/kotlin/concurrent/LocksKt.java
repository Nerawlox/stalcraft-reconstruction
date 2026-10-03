/*
 * Decompiled with CFR 0.152.
 */
package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\b\u00a2\u0006\u0002\u0010\u0005\u001a&\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\b\u00a2\u0006\u0002\u0010\b\u001a&\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\b\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\n"}, d2={"read", "T", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"})
@JvmName(name="LocksKt")
public final class LocksKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @InlineOnly
    private static final <T> T withLock(@NotNull Lock $receiver, Function0<? extends T> action) {
        $receiver.lock();
        try {
            T t = action.invoke();
            return t;
        }
        finally {
            InlineMarker.finallyStart(1);
            $receiver.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @InlineOnly
    private static final <T> T read(@NotNull ReentrantReadWriteLock $receiver, Function0<? extends T> action) {
        ReentrantReadWriteLock.ReadLock rl = $receiver.readLock();
        rl.lock();
        try {
            T t = action.invoke();
            return t;
        }
        finally {
            InlineMarker.finallyStart(1);
            rl.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @InlineOnly
    private static final <T> T write(@NotNull ReentrantReadWriteLock $receiver, Function0<? extends T> action) {
        ReentrantReadWriteLock.ReadLock rl = $receiver.readLock();
        int n = 0;
        int readCount = $receiver.getWriteHoldCount() == 0 ? $receiver.getReadHoldCount() : 0;
        int n2 = readCount - 1;
        if (n <= n2) {
            do {
                int it = ++n;
                rl.unlock();
            } while (n != n2);
        }
        ReentrantReadWriteLock.WriteLock wl = $receiver.writeLock();
        wl.lock();
        try {
            T t = action.invoke();
            return t;
        }
        finally {
            InlineMarker.finallyStart(1);
            int n3 = 0;
            int n4 = readCount - 1;
            if (n3 <= n4) {
                do {
                    int it = ++n3;
                    rl.lock();
                } while (n3 != n4);
            }
            wl.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}

