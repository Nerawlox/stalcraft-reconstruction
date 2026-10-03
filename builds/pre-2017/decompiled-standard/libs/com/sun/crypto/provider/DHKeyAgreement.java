/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESKey;
import com.sun.crypto.provider.DESedeKey;
import com.sun.crypto.provider.DHPublicKey;
import com.sun.crypto.provider.SunJCE;
import com.sun.crypto.provider.SunJCE_c;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class DHKeyAgreement
extends KeyAgreementSpi
implements SunJCE_c {
    private boolean a = false;
    private BigInteger b = null;
    private BigInteger c = null;
    private BigInteger d;
    private BigInteger e;

    public DHKeyAgreement() {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
    }

    protected void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            this.engineInit(key, null, secureRandom);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            // empty catch block
        }
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.a = false;
        this.b = null;
        this.c = null;
        if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Diffie-Hellman parameters expected");
        }
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("Diffie-Hellman private key expected");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey)key;
        if (algorithmParameterSpec != null) {
            this.b = ((DHParameterSpec)algorithmParameterSpec).getP();
            this.c = ((DHParameterSpec)algorithmParameterSpec).getG();
        }
        BigInteger bigInteger = dHPrivateKey.getParams().getP();
        BigInteger bigInteger2 = dHPrivateKey.getParams().getG();
        if (this.b != null && bigInteger != null && !this.b.equals(bigInteger)) {
            throw new InvalidKeyException("Incompatible parameters");
        }
        if (this.c != null && bigInteger2 != null && !this.c.equals(bigInteger2)) {
            throw new InvalidKeyException("Incompatible parameters");
        }
        if (this.b == null && bigInteger == null || this.c == null && bigInteger2 == null) {
            throw new InvalidKeyException("Missing parameters");
        }
        this.b = bigInteger;
        this.c = bigInteger2;
        this.d = dHPrivateKey.getX();
    }

    protected Key engineDoPhase(Key key, boolean bl) throws InvalidKeyException, IllegalStateException {
        if (!(key instanceof javax.crypto.interfaces.DHPublicKey)) {
            throw new InvalidKeyException("Diffie-Hellman public key expected");
        }
        javax.crypto.interfaces.DHPublicKey dHPublicKey = (javax.crypto.interfaces.DHPublicKey)key;
        if (this.b == null || this.c == null) {
            throw new IllegalStateException("Not initialized");
        }
        BigInteger bigInteger = dHPublicKey.getParams().getP();
        BigInteger bigInteger2 = dHPublicKey.getParams().getG();
        if (bigInteger != null && !this.b.equals(bigInteger)) {
            throw new InvalidKeyException("Incompatible parameters");
        }
        if (bigInteger2 != null && !this.c.equals(bigInteger2)) {
            throw new InvalidKeyException("Incompatible parameters");
        }
        this.e = dHPublicKey.getY();
        this.a = true;
        if (!bl) {
            byte[] byArray = this.engineGenerateSecret();
            return new DHPublicKey(new BigInteger(1, byArray), this.b, this.c);
        }
        return null;
    }

    protected byte[] engineGenerateSecret() throws IllegalStateException {
        if (!this.a) {
            throw new IllegalStateException("Wrong state");
        }
        this.a = false;
        BigInteger bigInteger = this.b;
        BigInteger bigInteger2 = this.e.modPow(this.d, bigInteger);
        byte[] byArray = bigInteger2.toByteArray();
        if (bigInteger2.bitLength() % 8 == 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
            return byArray2;
        }
        return byArray;
    }

    protected int engineGenerateSecret(byte[] byArray, int n) throws IllegalStateException, ShortBufferException {
        if (!this.a) {
            throw new IllegalStateException("Wrong state");
        }
        if (byArray == null) {
            throw new ShortBufferException("No buffer provided for shared secret");
        }
        BigInteger bigInteger = this.b;
        byte[] byArray2 = this.e.modPow(this.d, bigInteger).toByteArray();
        if (byArray2.length << 3 != bigInteger.bitLength()) {
            if (byArray.length - n < byArray2.length - 1) {
                throw new ShortBufferException("Buffer too short for shared secret");
            }
            System.arraycopy(byArray2, 1, byArray, n, byArray2.length - 1);
            this.a = false;
            return byArray2.length - 1;
        }
        if (byArray.length - n < byArray2.length) {
            throw new ShortBufferException("Buffer too short to hold shared secret");
        }
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        this.a = false;
        return byArray2.length;
    }

    protected SecretKey engineGenerateSecret(String string) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (string == null) {
            throw new NoSuchAlgorithmException("null algorithm");
        }
        byte[] byArray = this.engineGenerateSecret();
        if (string.equalsIgnoreCase("DES")) {
            return new DESKey(byArray);
        }
        if (string.equalsIgnoreCase("DESede") || string.equalsIgnoreCase("TripleDES")) {
            return new DESedeKey(byArray);
        }
        if (string.equalsIgnoreCase("Blowfish")) {
            int n = byArray.length;
            if (n >= 56) {
                n = 56;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, 0, n, "Blowfish");
            return secretKeySpec;
        }
        throw new NoSuchAlgorithmException("Unsupported secret key algorithm: " + string);
    }
}

