/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public final class Callables {
    private Callables() {
    }

    public static <T> Callable<T> returning(final @Nullable T value) {
        return new Callable<T>(){

            @Override
            public T call() {
                return value;
            }
        };
    }
}

