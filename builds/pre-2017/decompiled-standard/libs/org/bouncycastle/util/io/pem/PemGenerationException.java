/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.io.pem;

import java.io.IOException;

public class PemGenerationException
extends IOException {
    private Throwable cause;

    public PemGenerationException(String string, Throwable throwable) {
        super(string);
        this.cause = throwable;
    }

    public PemGenerationException(String string) {
        super(string);
    }

    public Throwable getCause() {
        return this.cause;
    }
}

