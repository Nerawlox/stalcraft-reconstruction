/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;

public final class DESKeyGenerator
extends KeyGeneratorSpi {
    private SecureRandom a = null;
    private static final byte[] b = new byte[]{-128, 64, 32, 16, 8, 4, 2};

    public DESKeyGenerator() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected void engineInit(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("DES key generation does not take any parameters");
    }

    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n != 56) {
            throw new InvalidParameterException("Wrong keysize: must be equal to 56");
        }
        this.engineInit(secureRandom);
    }

    protected SecretKey engineGenerateKey() {
        DESKey dESKey = null;
        if (this.a == null) {
            this.a = new SecureRandom();
        }
        try {
            byte[] byArray = new byte[8];
            do {
                this.a.nextBytes(byArray);
                DESKeyGenerator.a(byArray, 0);
            } while (DESKeySpec.isWeak(byArray, 0));
            dESKey = new DESKey(byArray);
        }
        catch (InvalidKeyException invalidKeyException) {
            // empty catch block
        }
        return dESKey;
    }

    static void a(byte[] byArray, int n) {
        if (byArray == null) {
            return;
        }
        int n2 = 0;
        while (n2 < 8) {
            int n3 = 0;
            int n4 = 0;
            while (n4 < b.length) {
                if ((byArray[n2 + n] & b[n4]) == b[n4]) {
                    ++n3;
                }
                ++n4;
            }
            byArray[n2 + n] = n3 & true ? (byte)(byArray[n2 + n] & 0xFFFFFFFE) : (byte)(byArray[n2 + n] | 1);
            ++n2;
        }
    }
}

