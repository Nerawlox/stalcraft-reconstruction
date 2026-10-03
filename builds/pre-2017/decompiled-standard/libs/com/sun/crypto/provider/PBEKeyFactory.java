/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.PBEKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.PBEKeySpec;

public final class PBEKeyFactory
extends SecretKeyFactorySpi {
    static /* synthetic */ Class a;

    public PBEKeyFactory() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null || !(keySpec instanceof PBEKeySpec)) {
            throw new InvalidKeySpecException("Invalid key spec");
        }
        return new PBEKey((PBEKeySpec)keySpec);
    }

    protected KeySpec engineGetKeySpec(SecretKey secretKey, Class clazz) throws InvalidKeySpecException {
        try {
            if (secretKey != null && secretKey instanceof SecretKey && secretKey.getAlgorithm().equalsIgnoreCase("PBEWithMD5AndDES") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                Class<?> clazz2 = Class.forName("javax.crypto.spec.PBEKeySpec");
                if (clazz != null && clazz2.isAssignableFrom(clazz)) {
                    byte[] byArray = secretKey.getEncoded();
                    char[] cArray = new char[byArray.length];
                    int n = 0;
                    while (n < cArray.length) {
                        cArray[n] = (char)(byArray[n] & 0x7F);
                        ++n;
                    }
                    PBEKeySpec pBEKeySpec = new PBEKeySpec(cArray);
                    Arrays.fill(cArray, ' ');
                    Arrays.fill(byArray, (byte)0);
                    return pBEKeySpec;
                }
                throw new InvalidKeySpecException("Invalid key spec");
            }
            throw new InvalidKeySpecException("Invalid key format/algorithm");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidKeySpecException("Unsupported key spec: " + classNotFoundException.getMessage());
        }
    }

    protected SecretKey engineTranslateKey(SecretKey secretKey) throws InvalidKeyException {
        try {
            if (secretKey != null && secretKey.getAlgorithm().equalsIgnoreCase("PBEWithMD5AndDES") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                if (secretKey instanceof PBEKey) {
                    return secretKey;
                }
                PBEKeySpec pBEKeySpec = (PBEKeySpec)this.engineGetKeySpec(secretKey, a == null ? (a = PBEKeyFactory.class$("javax.crypto.spec.PBEKeySpec")) : a);
                return this.engineGenerateSecret(pBEKeySpec);
            }
            throw new InvalidKeyException("Invalid key format/algorithm");
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new InvalidKeyException("Cannot translate key: " + invalidKeySpecException.getMessage());
        }
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

