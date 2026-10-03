/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.SunJCE_b;

public class SecretKeyFactory {
    private Provider a;
    private String b;
    private SecretKeyFactorySpi c;

    protected SecretKeyFactory(SecretKeyFactorySpi secretKeyFactorySpi, Provider provider, String string) {
        this.c = secretKeyFactorySpi;
        this.a = provider;
        this.b = string;
    }

    public static final SecretKeyFactory getInstance(String string) throws NoSuchAlgorithmException {
        try {
            Object[] objectArray = SunJCE_b.a(string, "SecretKeyFactory", (String)null);
            return new SecretKeyFactory((SecretKeyFactorySpi)objectArray[0], (Provider)objectArray[1], string);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new NoSuchAlgorithmException(string + " not found");
        }
    }

    public static final SecretKeyFactory getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Object[] objectArray = SunJCE_b.a(string, "SecretKeyFactory", string2);
        return new SecretKeyFactory((SecretKeyFactorySpi)objectArray[0], (Provider)objectArray[1], string);
    }

    public final Provider getProvider() {
        return this.a;
    }

    public final String getAlgorithm() {
        return this.b;
    }

    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        return this.c.engineGenerateSecret(keySpec);
    }

    public final KeySpec getKeySpec(SecretKey secretKey, Class clazz) throws InvalidKeySpecException {
        return this.c.engineGetKeySpec(secretKey, clazz);
    }

    public final SecretKey translateKey(SecretKey secretKey) throws InvalidKeyException {
        return this.c.engineTranslateKey(secretKey);
    }
}

