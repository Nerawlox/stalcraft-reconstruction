/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DHParameterGenerator;
import com.sun.crypto.provider.DHPrivateKey;
import com.sun.crypto.provider.DHPublicKey;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public final class DHKeyPairGenerator
extends KeyPairGeneratorSpi {
    private BigInteger a;
    private BigInteger b;
    private BigInteger c;
    private BigInteger d;
    private int e = 1024;
    private int f;
    private SecureRandom g;
    static /* synthetic */ Class h;

    public void initialize(int n, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            throw new InvalidParameterException("Keysize must be multiple of 64, and can only range from 512 to 1024 (inclusive)");
        }
        this.e = n;
        this.f = 0;
        this.g = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Inappropriate parameter type");
        }
        this.c = ((DHParameterSpec)algorithmParameterSpec).getP();
        this.e = this.c.bitLength();
        if (this.e < 512 || this.e > 1024 || this.e % 64 != 0) {
            throw new InvalidAlgorithmParameterException("Prime size must be multiple of 64, and can only range from 512 to 1024 (inclusive)");
        }
        this.d = ((DHParameterSpec)algorithmParameterSpec).getG();
        this.f = ((DHParameterSpec)algorithmParameterSpec).getL();
        this.g = secureRandom;
        if (this.f != 0 && this.f >= this.e) {
            throw new InvalidAlgorithmParameterException("Exponent size must be less than modulus size");
        }
    }

    public KeyPair generateKeyPair() {
        KeyPair keyPair = null;
        if (this.f == 0) {
            this.f = this.e - 1;
        }
        if (this.g == null) {
            this.g = new SecureRandom();
        }
        try {
            Object object;
            Object object2;
            if (this.c == null || this.d == null) {
                object2 = new DHGenParameterSpec(this.e, this.f);
                DHParameterGenerator dHParameterGenerator = new DHParameterGenerator();
                dHParameterGenerator.engineInit((AlgorithmParameterSpec)object2, null);
                AlgorithmParameters algorithmParameters = dHParameterGenerator.engineGenerateParameters();
                object = (DHParameterSpec)algorithmParameters.getParameterSpec(h == null ? (h = DHKeyPairGenerator.class$("javax.crypto.spec.DHParameterSpec")) : h);
                this.c = ((DHParameterSpec)object).getP();
                this.d = ((DHParameterSpec)object).getG();
            }
            this.b = new BigInteger(this.f, this.g);
            this.a = this.d.modPow(this.b, this.c);
            object2 = new DHPublicKey(this.a, this.c, this.d, this.f);
            object = new DHPrivateKey(this.b, this.c, this.d, this.f);
            keyPair = new KeyPair((PublicKey)object2, (PrivateKey)object);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new RuntimeException(invalidAlgorithmParameterException.getMessage());
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new RuntimeException(invalidParameterSpecException.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new RuntimeException(invalidKeyException.getMessage());
        }
        return keyPair;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

