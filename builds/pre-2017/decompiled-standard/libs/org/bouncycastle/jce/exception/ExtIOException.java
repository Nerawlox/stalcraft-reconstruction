/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.exception;

import java.io.IOException;
import org.bouncycastle.jce.exception.ExtException;

public class ExtIOException
extends IOException
implements ExtException {
    private Throwable cause;

    public ExtIOException(String string, Throwable throwable) {
        super(string);
        this.cause = throwable;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

