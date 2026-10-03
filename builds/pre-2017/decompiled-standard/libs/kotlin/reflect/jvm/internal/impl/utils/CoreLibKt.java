/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoreLibKt {
    @NotNull
    public static final <T> T sure(@Nullable T $receiver, @NotNull Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        T t = $receiver;
        if (t == null) {
            throw (Throwable)((Object)new AssertionError((Object)message.invoke()));
        }
        return t;
    }
}

