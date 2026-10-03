/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class HmacMD5KeyGenerator
extends KeyGeneratorSpi {
    private SecureRandom a = null;
    private int b = 64;

    public HmacMD5KeyGenerator() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected void engineInit(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("HMAC-MD5 key generation does not take any parameters");
    }

    protected void engineInit(int n, SecureRandom secureRandom) {
        this.b = (n + 7) / 8;
        this.engineInit(secureRandom);
    }

    protected SecretKey engineGenerateKey() {
        if (this.a == null) {
            this.a = new SecureRandom();
        }
        byte[] byArray = new byte[this.b];
        this.a.nextBytes(byArray);
        return new SecretKeySpec(byArray, "HmacMD5");
    }
}

