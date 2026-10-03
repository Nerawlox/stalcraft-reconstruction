/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public final class DHParameterGenerator
extends AlgorithmParameterGeneratorSpi {
    private int a = 1024;
    private int b;
    private SecureRandom c;
    static /* synthetic */ Class d;

    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            throw new InvalidParameterException("Keysize must be multiple of 64, and can only range from 512 to 1024 (inclusive)");
        }
        this.a = n;
        this.c = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Inappropriate parameter type");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec)algorithmParameterSpec;
        this.a = dHGenParameterSpec.getPrimeSize();
        if (this.a < 512 || this.a > 1024 || this.a % 64 != 0) {
            throw new InvalidAlgorithmParameterException("Modulus size must be multiple of 64, and can only range from 512 to 1024 (inclusive)");
        }
        this.b = dHGenParameterSpec.getExponentSize();
        if (this.b <= 0) {
            throw new InvalidAlgorithmParameterException("Exponent size must be greater than zero");
        }
        if (this.b >= this.a) {
            throw new InvalidAlgorithmParameterException("Exponent size must be less than modulus size");
        }
    }

    protected AlgorithmParameters engineGenerateParameters() {
        AlgorithmParameters algorithmParameters = null;
        if (this.b == 0) {
            this.b = this.a - 1;
        }
        if (this.c == null) {
            this.c = new SecureRandom();
        }
        try {
            AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("DSA");
            algorithmParameterGenerator.init(this.a);
            algorithmParameters = algorithmParameterGenerator.generateParameters();
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec)algorithmParameters.getParameterSpec(d == null ? (d = DHParameterGenerator.class$("java.security.spec.DSAParameterSpec")) : d);
            DHParameterSpec dHParameterSpec = this.b > 0 ? new DHParameterSpec(dSAParameterSpec.getP(), dSAParameterSpec.getG(), this.b) : new DHParameterSpec(dSAParameterSpec.getP(), dSAParameterSpec.getG());
            algorithmParameters = AlgorithmParameters.getInstance("DH", "SunJCE");
            algorithmParameters.init(dHParameterSpec);
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new RuntimeException(invalidParameterSpecException.getMessage());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException.getMessage());
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new RuntimeException(noSuchProviderException.getMessage());
        }
        return algorithmParameters;
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

