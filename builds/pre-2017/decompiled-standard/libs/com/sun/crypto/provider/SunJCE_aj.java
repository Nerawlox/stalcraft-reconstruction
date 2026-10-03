/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.CipherSpi;

final class SunJCE_aj
extends Cipher {
    protected SunJCE_aj(CipherSpi cipherSpi, Provider provider, String string) {
        super(cipherSpi, provider, string);
    }
}

