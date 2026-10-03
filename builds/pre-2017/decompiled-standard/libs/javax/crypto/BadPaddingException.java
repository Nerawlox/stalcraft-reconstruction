/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.GeneralSecurityException;

public class BadPaddingException
extends GeneralSecurityException {
    public BadPaddingException() {
    }

    public BadPaddingException(String string) {
        super(string);
    }
}

