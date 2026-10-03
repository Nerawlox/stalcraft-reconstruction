/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

public class CryptoException
extends Exception {
    private Throwable cause;

    public CryptoException() {
    }

    public CryptoException(String string) {
        super(string);
    }

    public CryptoException(String string, Throwable throwable) {
        super(string);
        this.cause = throwable;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

