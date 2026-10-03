/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.reflect;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassFinderKt {
    @Nullable
    public static final Class<?> tryLoadClass(@NotNull ClassLoader $receiver, @NotNull String fqName2) {
        Class<?> clazz;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        try {
            clazz = $receiver.loadClass(fqName2);
        }
        catch (ClassNotFoundException e) {
            clazz = null;
        }
        return clazz;
    }
}

