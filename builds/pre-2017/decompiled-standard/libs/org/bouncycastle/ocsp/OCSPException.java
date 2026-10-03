/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

public class OCSPException
extends Exception {
    Exception e;

    public OCSPException(String string) {
        super(string);
    }

    public OCSPException(String string, Exception exception) {
        super(string);
        this.e = exception;
    }

    public Exception getUnderlyingException() {
        return this.e;
    }

    public Throwable getCause() {
        return this.e;
    }
}

