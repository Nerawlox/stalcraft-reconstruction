/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.SunJCE_b;

public class KeyGenerator {
    private Provider a;
    private KeyGeneratorSpi b;
    private String c;

    protected KeyGenerator(KeyGeneratorSpi keyGeneratorSpi, Provider provider, String string) {
        this.b = keyGeneratorSpi;
        this.a = provider;
        this.c = string;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public static final KeyGenerator getInstance(String string) throws NoSuchAlgorithmException {
        try {
            Object[] objectArray = SunJCE_b.a(string, "KeyGenerator", (String)null);
            return new KeyGenerator((KeyGeneratorSpi)objectArray[0], (Provider)objectArray[1], string);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException(string + " not found");
        }
    }

    public static final KeyGenerator getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Object[] objectArray = SunJCE_b.a(string, "KeyGenerator", string2);
        return new KeyGenerator((KeyGeneratorSpi)objectArray[0], (Provider)objectArray[1], string);
    }

    public final Provider getProvider() {
        return this.a;
    }

    public final void init(SecureRandom secureRandom) {
        this.b.engineInit(secureRandom);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.b.engineInit(algorithmParameterSpec, new SecureRandom());
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.b.engineInit(algorithmParameterSpec, secureRandom);
    }

    public final void init(int n) {
        this.b.engineInit(n, new SecureRandom());
    }

    public final void init(int n, SecureRandom secureRandom) {
        this.b.engineInit(n, secureRandom);
    }

    public final SecretKey generateKey() {
        return this.b.engineGenerateKey();
    }
}

