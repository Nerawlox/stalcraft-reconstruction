/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util;

public class StreamParsingException
extends Exception {
    Throwable _e;

    public StreamParsingException(String string, Throwable throwable) {
        super(string);
        this._e = throwable;
    }

    public Throwable getCause() {
        return this._e;
    }
}

