/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

public class TlsRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 1928023487348344086L;
    Throwable e;

    public TlsRuntimeException(String string, Throwable throwable) {
        super(string);
        this.e = throwable;
    }

    public TlsRuntimeException(String string) {
        super(string);
    }

    public Throwable getCause() {
        return this.e;
    }
}

