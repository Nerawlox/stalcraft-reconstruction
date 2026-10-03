/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

final class SunJCE_k {
    SunJCE_k() {
    }

    static final PublicKey a(byte[] byArray, String string) throws InvalidKeyException, NoSuchAlgorithmException {
        PublicKey publicKey = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(string, "SunJCE");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            try {
                KeyFactory keyFactory = KeyFactory.getInstance(string);
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
                publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException2) {
                throw new NoSuchAlgorithmException("No installed providers can create keys for the " + string + "algorithm");
            }
            catch (InvalidKeySpecException invalidKeySpecException) {
                throw new InvalidKeyException("Cannot construct public key: " + invalidKeySpecException);
            }
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new InvalidKeyException("Cannot construct public key: " + invalidKeySpecException);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            // empty catch block
        }
        return publicKey;
    }

    static final PrivateKey b(byte[] byArray, String string) throws InvalidKeyException, NoSuchAlgorithmException {
        PrivateKey privateKey = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(string, "SunJCE");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(byArray);
            return keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            try {
                KeyFactory keyFactory = KeyFactory.getInstance(string);
                PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(byArray);
                privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException2) {
                throw new NoSuchAlgorithmException("No installed providers can create keys for the " + string + "algorithm");
            }
            catch (InvalidKeySpecException invalidKeySpecException) {
                throw new InvalidKeyException("Cannot construct private key: " + invalidKeySpecException);
            }
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new InvalidKeyException("Cannot construct private key: " + invalidKeySpecException);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            // empty catch block
        }
        return privateKey;
    }

    static final SecretKey c(byte[] byArray, String string) {
        return new SecretKeySpec(byArray, string);
    }
}

