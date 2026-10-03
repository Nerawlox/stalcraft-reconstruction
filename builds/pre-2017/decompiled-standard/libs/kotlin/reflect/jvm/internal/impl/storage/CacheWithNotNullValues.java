/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public interface CacheWithNotNullValues<K, V> {
    @NotNull
    public V computeIfAbsent(K var1, @NotNull Function0<? extends V> var2);
}

