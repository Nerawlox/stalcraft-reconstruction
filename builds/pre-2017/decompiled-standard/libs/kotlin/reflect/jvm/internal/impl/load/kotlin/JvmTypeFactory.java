/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;

public interface JvmTypeFactory<T> {
    @NotNull
    public T boxType(@NotNull T var1);

    @NotNull
    public T createFromString(@NotNull String var1);

    @NotNull
    public T createObjectType(@NotNull String var1);

    @NotNull
    public String toString(@NotNull T var1);

    @NotNull
    public T getJavaLangClassType();
}

