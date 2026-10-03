/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.CryptoException;

public class InvalidCipherTextException
extends CryptoException {
    public InvalidCipherTextException() {
    }

    public InvalidCipherTextException(String string) {
        super(string);
    }
}

