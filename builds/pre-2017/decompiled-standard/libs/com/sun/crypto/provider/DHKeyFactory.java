/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DHPrivateKey;
import com.sun.crypto.provider.DHPublicKey;
import com.sun.crypto.provider.SunJCE;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;

public final class DHKeyFactory
extends KeyFactorySpi {
    static /* synthetic */ Class a;
    static /* synthetic */ Class b;

    public DHKeyFactory() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        try {
            if (keySpec instanceof DHPublicKeySpec) {
                DHPublicKeySpec dHPublicKeySpec = (DHPublicKeySpec)keySpec;
                return new DHPublicKey(dHPublicKeySpec.getY(), dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
            }
            if (keySpec instanceof X509EncodedKeySpec) {
                return new DHPublicKey(((X509EncodedKeySpec)keySpec).getEncoded());
            }
            throw new InvalidKeySpecException("Inappropriate key specification");
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InvalidKeySpecException("Inappropriate key specification");
        }
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        try {
            if (keySpec instanceof DHPrivateKeySpec) {
                DHPrivateKeySpec dHPrivateKeySpec = (DHPrivateKeySpec)keySpec;
                return new DHPrivateKey(dHPrivateKeySpec.getX(), dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
            }
            if (keySpec instanceof PKCS8EncodedKeySpec) {
                return new DHPrivateKey(((PKCS8EncodedKeySpec)keySpec).getEncoded());
            }
            throw new InvalidKeySpecException("Inappropriate key specification");
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InvalidKeySpecException("Inappropriate key specification");
        }
    }

    protected KeySpec engineGetKeySpec(Key key, Class clazz) throws InvalidKeySpecException {
        try {
            if (key instanceof javax.crypto.interfaces.DHPublicKey) {
                Class<?> clazz2 = Class.forName("javax.crypto.spec.DHPublicKeySpec");
                Class<?> clazz3 = Class.forName("java.security.spec.X509EncodedKeySpec");
                if (clazz2.isAssignableFrom(clazz)) {
                    javax.crypto.interfaces.DHPublicKey dHPublicKey = (javax.crypto.interfaces.DHPublicKey)key;
                    DHParameterSpec dHParameterSpec = dHPublicKey.getParams();
                    return new DHPublicKeySpec(dHPublicKey.getY(), dHParameterSpec.getP(), dHParameterSpec.getG());
                }
                if (clazz3.isAssignableFrom(clazz)) {
                    return new X509EncodedKeySpec(key.getEncoded());
                }
                throw new InvalidKeySpecException("Inappropriate key specification");
            }
            if (key instanceof javax.crypto.interfaces.DHPrivateKey) {
                Class<?> clazz4 = Class.forName("javax.crypto.spec.DHPrivateKeySpec");
                Class<?> clazz5 = Class.forName("java.security.spec.PKCS8EncodedKeySpec");
                if (clazz4.isAssignableFrom(clazz)) {
                    javax.crypto.interfaces.DHPrivateKey dHPrivateKey = (javax.crypto.interfaces.DHPrivateKey)key;
                    DHParameterSpec dHParameterSpec = dHPrivateKey.getParams();
                    return new DHPrivateKeySpec(dHPrivateKey.getX(), dHParameterSpec.getP(), dHParameterSpec.getG());
                }
                if (clazz5.isAssignableFrom(clazz)) {
                    return new PKCS8EncodedKeySpec(key.getEncoded());
                }
                throw new InvalidKeySpecException("Inappropriate key specification");
            }
            throw new InvalidKeySpecException("Inappropriate key type");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidKeySpecException("Unsupported key specification: " + classNotFoundException.getMessage());
        }
    }

    protected Key engineTranslateKey(Key key) throws InvalidKeyException {
        try {
            if (key instanceof javax.crypto.interfaces.DHPublicKey) {
                if (key instanceof DHPublicKey) {
                    return key;
                }
                DHPublicKeySpec dHPublicKeySpec = (DHPublicKeySpec)this.engineGetKeySpec(key, a == null ? (a = DHKeyFactory.class$("javax.crypto.spec.DHPublicKeySpec")) : a);
                return this.engineGeneratePublic(dHPublicKeySpec);
            }
            if (key instanceof javax.crypto.interfaces.DHPrivateKey) {
                if (key instanceof DHPrivateKey) {
                    return key;
                }
                DHPrivateKeySpec dHPrivateKeySpec = (DHPrivateKeySpec)this.engineGetKeySpec(key, b == null ? (b = DHKeyFactory.class$("javax.crypto.spec.DHPrivateKeySpec")) : b);
                return this.engineGeneratePrivate(dHPrivateKeySpec);
            }
            throw new InvalidKeyException("Wrong algorithm type");
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

