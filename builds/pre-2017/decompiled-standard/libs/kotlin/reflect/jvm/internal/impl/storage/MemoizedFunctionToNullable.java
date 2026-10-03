/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;

public interface MemoizedFunctionToNullable<P, R>
extends Function1<P, R> {
    public boolean isComputed(P var1);
}

