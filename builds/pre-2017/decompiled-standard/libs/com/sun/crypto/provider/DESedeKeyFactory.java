/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESedeKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.DESedeKeySpec;

public final class DESedeKeyFactory
extends SecretKeyFactorySpi {
    static /* synthetic */ Class a;

    public DESedeKeyFactory() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        DESedeKey dESedeKey = null;
        try {
            if (keySpec == null || !(keySpec instanceof DESedeKeySpec)) {
                throw new InvalidKeySpecException("Inappropriate key specification");
            }
            DESedeKeySpec dESedeKeySpec = (DESedeKeySpec)keySpec;
            dESedeKey = new DESedeKey(dESedeKeySpec.getKey());
        }
        catch (InvalidKeyException invalidKeyException) {
            // empty catch block
        }
        return dESedeKey;
    }

    protected KeySpec engineGetKeySpec(SecretKey secretKey, Class clazz) throws InvalidKeySpecException {
        try {
            if (secretKey != null && secretKey instanceof SecretKey && secretKey.getAlgorithm().equalsIgnoreCase("DESede") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                Class<?> clazz2 = Class.forName("javax.crypto.spec.DESedeKeySpec");
                if (clazz != null && clazz2.isAssignableFrom(clazz)) {
                    return new DESedeKeySpec(secretKey.getEncoded());
                }
                throw new InvalidKeySpecException("Inappropriate key specification");
            }
            throw new InvalidKeySpecException("Inappropriate key format/algorithm");
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InvalidKeySpecException("Secret key has wrong size");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidKeySpecException("Unsupported key specification: " + classNotFoundException.getMessage());
        }
    }

    protected SecretKey engineTranslateKey(SecretKey secretKey) throws InvalidKeyException {
        try {
            if (secretKey != null && secretKey.getAlgorithm().equalsIgnoreCase("DESede") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                if (secretKey instanceof DESedeKey) {
                    return secretKey;
                }
                DESedeKeySpec dESedeKeySpec = (DESedeKeySpec)this.engineGetKeySpec(secretKey, a == null ? (a = DESedeKeyFactory.class$("javax.crypto.spec.DESedeKeySpec")) : a);
                return this.engineGenerateSecret(dESedeKeySpec);
            }
            throw new InvalidKeyException("Inappropriate key format/algorithm");
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new InvalidKeyException("Cannot translate key");
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

