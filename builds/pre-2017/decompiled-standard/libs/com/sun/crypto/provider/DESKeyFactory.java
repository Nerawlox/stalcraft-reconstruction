/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.DESKeySpec;

public final class DESKeyFactory
extends SecretKeyFactorySpi {
    static /* synthetic */ Class a;

    public DESKeyFactory() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        DESKey dESKey = null;
        try {
            if (keySpec == null || !(keySpec instanceof DESKeySpec)) {
                throw new InvalidKeySpecException("Inappropriate key specification");
            }
            DESKeySpec dESKeySpec = (DESKeySpec)keySpec;
            dESKey = new DESKey(dESKeySpec.getKey());
        }
        catch (InvalidKeyException invalidKeyException) {
            // empty catch block
        }
        return dESKey;
    }

    protected KeySpec engineGetKeySpec(SecretKey secretKey, Class clazz) throws InvalidKeySpecException {
        try {
            if (secretKey != null && secretKey instanceof SecretKey && secretKey.getAlgorithm().equalsIgnoreCase("DES") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                Class<?> clazz2 = Class.forName("javax.crypto.spec.DESKeySpec");
                if (clazz != null && clazz2.isAssignableFrom(clazz)) {
                    return new DESKeySpec(secretKey.getEncoded());
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
            if (secretKey != null && secretKey.getAlgorithm().equalsIgnoreCase("DES") && secretKey.getFormat().equalsIgnoreCase("RAW")) {
                if (secretKey instanceof DESKey) {
                    return secretKey;
                }
                DESKeySpec dESKeySpec = (DESKeySpec)this.engineGetKeySpec(secretKey, a == null ? (a = DESKeyFactory.class$("javax.crypto.spec.DESKeySpec")) : a);
                return this.engineGenerateSecret(dESKeySpec);
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

