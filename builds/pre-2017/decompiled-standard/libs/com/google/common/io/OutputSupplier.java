/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import java.io.IOException;

public interface OutputSupplier<T> {
    public T getOutput() throws IOException;
}

