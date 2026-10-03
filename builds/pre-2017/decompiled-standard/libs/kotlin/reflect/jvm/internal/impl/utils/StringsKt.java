/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StringsKt {
    @NotNull
    public static final String join(@NotNull Iterable<? extends Object> collection, @NotNull String separator) {
        Intrinsics.checkParameterIsNotNull(collection, "collection");
        Intrinsics.checkParameterIsNotNull(separator, "separator");
        return CollectionsKt.joinToString$default(collection, separator, null, null, 0, null, null, 62, null);
    }
}

