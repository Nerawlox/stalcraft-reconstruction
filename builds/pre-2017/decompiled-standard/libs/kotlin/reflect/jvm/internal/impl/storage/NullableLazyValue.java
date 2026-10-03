/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;

public interface NullableLazyValue<T>
extends Function0<T> {
    public boolean isComputed();

    public boolean isComputing();
}

