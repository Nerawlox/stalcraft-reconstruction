/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.GeneralSecurityException;

public class NoSuchPaddingException
extends GeneralSecurityException {
    public NoSuchPaddingException() {
    }

    public NoSuchPaddingException(String string) {
        super(string);
    }
}

