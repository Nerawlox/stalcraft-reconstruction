/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import javax.crypto.Cipher;
import javax.crypto.NullCipherSpi;
import javax.crypto.SunJCE_b;

public class NullCipher
extends Cipher {
    public NullCipher() {
        super(new NullCipherSpi(), null, null, null, new Boolean(SunJCE_b.c()), null);
    }
}

