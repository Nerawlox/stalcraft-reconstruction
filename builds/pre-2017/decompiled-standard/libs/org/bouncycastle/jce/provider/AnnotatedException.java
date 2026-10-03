/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import org.bouncycastle.jce.exception.ExtException;

public class AnnotatedException
extends Exception
implements ExtException {
    private Throwable _underlyingException;

    AnnotatedException(String string, Throwable throwable) {
        super(string);
        this._underlyingException = throwable;
    }

    AnnotatedException(String string) {
        this(string, null);
    }

    Throwable getUnderlyingException() {
        return this._underlyingException;
    }

    public Throwable getCause() {
        return this._underlyingException;
    }
}

