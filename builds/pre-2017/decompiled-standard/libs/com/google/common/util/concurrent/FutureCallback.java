/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

public interface FutureCallback<V> {
    public void onSuccess(V var1);

    public void onFailure(Throwable var1);
}

