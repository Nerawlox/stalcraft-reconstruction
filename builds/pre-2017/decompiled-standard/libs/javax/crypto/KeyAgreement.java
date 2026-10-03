/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.SunJCE_b;

public class KeyAgreement {
    private Provider a;
    private KeyAgreementSpi b;
    private String c;

    protected KeyAgreement(KeyAgreementSpi keyAgreementSpi, Provider provider, String string) {
        this.b = keyAgreementSpi;
        this.a = provider;
        this.c = string;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public static final KeyAgreement getInstance(String string) throws NoSuchAlgorithmException {
        try {
            Object[] objectArray = SunJCE_b.a(string, "KeyAgreement", (String)null);
            return new KeyAgreement((KeyAgreementSpi)objectArray[0], (Provider)objectArray[1], string);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException(string + " not found");
        }
    }

    public static final KeyAgreement getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Object[] objectArray = SunJCE_b.a(string, "KeyAgreement", string2);
        return new KeyAgreement((KeyAgreementSpi)objectArray[0], (Provider)objectArray[1], string);
    }

    public final Provider getProvider() {
        return this.a;
    }

    public final void init(Key key) throws InvalidKeyException {
        this.b.engineInit(key, new SecureRandom());
    }

    public final void init(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        this.b.engineInit(key, secureRandom);
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.b.engineInit(key, algorithmParameterSpec, new SecureRandom());
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.b.engineInit(key, algorithmParameterSpec, secureRandom);
    }

    public final Key doPhase(Key key, boolean bl) throws InvalidKeyException, IllegalStateException {
        return this.b.engineDoPhase(key, bl);
    }

    public final byte[] generateSecret() throws IllegalStateException {
        return this.b.engineGenerateSecret();
    }

    public final int generateSecret(byte[] byArray, int n) throws IllegalStateException, ShortBufferException {
        return this.b.engineGenerateSecret(byArray, n);
    }

    public final SecretKey generateSecret(String string) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        return this.b.engineGenerateSecret(string);
    }
}

