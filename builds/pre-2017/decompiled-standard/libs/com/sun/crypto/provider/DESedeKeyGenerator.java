/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESKeyGenerator;
import com.sun.crypto.provider.DESedeKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;

public final class DESedeKeyGenerator
extends KeyGeneratorSpi {
    private SecureRandom a;
    private int b;

    public DESedeKeyGenerator() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected void engineInit(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Triple DES key generation does not take any parameters");
    }

    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n != 112 && n != 168) {
            throw new InvalidParameterException("Wrong keysize: must be equal to 112 or 168");
        }
        this.b = n;
        this.engineInit(secureRandom);
    }

    protected SecretKey engineGenerateKey() {
        Object object;
        if (this.a == null) {
            this.a = new SecureRandom();
        }
        byte[] byArray = new byte[24];
        if (this.b == 168) {
            this.a.nextBytes(byArray);
            DESKeyGenerator.a(byArray, 0);
            DESKeyGenerator.a(byArray, 8);
            DESKeyGenerator.a(byArray, 16);
        } else {
            object = new byte[16];
            this.a.nextBytes((byte[])object);
            DESKeyGenerator.a(object, 0);
            DESKeyGenerator.a(object, 8);
            System.arraycopy(object, 0, byArray, 0, ((byte[])object).length);
            System.arraycopy(object, 0, byArray, 16, 8);
            Arrays.fill(object, (byte)0);
        }
        object = null;
        try {
            object = new DESedeKey(byArray);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new RuntimeException(invalidKeyException.getMessage());
        }
        Arrays.fill(byArray, (byte)0);
        return object;
    }
}

