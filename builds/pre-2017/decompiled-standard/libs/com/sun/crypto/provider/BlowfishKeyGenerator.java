/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class BlowfishKeyGenerator
extends KeyGeneratorSpi {
    private SecureRandom a = null;
    private int b = 7;

    public BlowfishKeyGenerator() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected void engineInit(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Blowfish key generation does not take any parameters");
    }

    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n % 8 != 0 || n < 32 || n > 448) {
            throw new InvalidParameterException("Keysize must be multiple of 8, and can only range from 32 to 448 (inclusive)");
        }
        this.b = n / 8;
        this.engineInit(secureRandom);
    }

    protected SecretKey engineGenerateKey() {
        if (this.a == null) {
            this.a = new SecureRandom();
        }
        byte[] byArray = new byte[this.b];
        this.a.nextBytes(byArray);
        return new SecretKeySpec(byArray, "Blowfish");
    }
}

