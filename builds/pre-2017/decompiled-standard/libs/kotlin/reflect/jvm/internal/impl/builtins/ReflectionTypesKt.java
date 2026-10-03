/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ReflectionTypesKt {
    @NotNull
    private static final FqName KOTLIN_REFLECT_FQ_NAME = new FqName("kotlin.reflect");

    @NotNull
    public static final FqName getKOTLIN_REFLECT_FQ_NAME() {
        return KOTLIN_REFLECT_FQ_NAME;
    }
}

