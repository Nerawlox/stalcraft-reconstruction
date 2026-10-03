/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.i18n;

import java.util.Locale;
import org.bouncycastle.i18n.ErrorBundle;

public class LocalizedException
extends Exception {
    protected ErrorBundle message;
    private Throwable cause;

    public LocalizedException(ErrorBundle errorBundle) {
        super(errorBundle.getText(Locale.getDefault()));
        this.message = errorBundle;
    }

    public LocalizedException(ErrorBundle errorBundle, Throwable throwable) {
        super(errorBundle.getText(Locale.getDefault()));
        this.message = errorBundle;
        this.cause = throwable;
    }

    public ErrorBundle getErrorMessage() {
        return this.message;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

