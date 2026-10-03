/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;
import org.bouncycastle.util.Strings;

public class KeyAgreementSpi
extends javax.crypto.KeyAgreementSpi {
    private BigInteger x;
    private BigInteger p;
    private BigInteger g;
    private BigInteger result;
    private static final Hashtable algorithms = new Hashtable();

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        byte[] byArray = bigInteger.toByteArray();
        if (byArray[0] == 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
            return byArray2;
        }
        return byArray;
    }

    protected Key engineDoPhase(Key key, boolean bl) throws InvalidKeyException, IllegalStateException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (!(key instanceof DHPublicKey)) {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        DHPublicKey dHPublicKey = (DHPublicKey)key;
        if (!dHPublicKey.getParams().getG().equals(this.g) || !dHPublicKey.getParams().getP().equals(this.p)) {
            throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
        }
        if (bl) {
            this.result = ((DHPublicKey)key).getY().modPow(this.x, this.p);
            return null;
        }
        this.result = ((DHPublicKey)key).getY().modPow(this.x, this.p);
        return new BCDHPublicKey(this.result, dHPublicKey.getParams());
    }

    protected byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        return this.bigIntToBytes(this.result);
    }

    protected int engineGenerateSecret(byte[] byArray, int n) throws IllegalStateException, ShortBufferException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        byte[] byArray2 = this.bigIntToBytes(this.result);
        if (byArray.length - n < byArray2.length) {
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        return byArray2.length;
    }

    protected SecretKey engineGenerateSecret(String string) {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        String string2 = Strings.toUpperCase(string);
        byte[] byArray = this.bigIntToBytes(this.result);
        if (algorithms.containsKey(string2)) {
            Integer n = (Integer)algorithms.get(string2);
            byte[] byArray2 = new byte[n / 8];
            System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
            if (string2.startsWith("DES")) {
                DESParameters.setOddParity(byArray2);
            }
            return new SecretKeySpec(byArray2, string);
        }
        return new SecretKeySpec(byArray, string);
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey)key;
        if (algorithmParameterSpec != null) {
            if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            DHParameterSpec dHParameterSpec = (DHParameterSpec)algorithmParameterSpec;
            this.p = dHParameterSpec.getP();
            this.g = dHParameterSpec.getG();
        } else {
            this.p = dHPrivateKey.getParams().getP();
            this.g = dHPrivateKey.getParams().getG();
        }
        this.x = this.result = dHPrivateKey.getX();
    }

    protected void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey)key;
        this.p = dHPrivateKey.getParams().getP();
        this.g = dHPrivateKey.getParams().getG();
        this.x = this.result = dHPrivateKey.getX();
    }

    static {
        Integer n = new Integer(64);
        Integer n2 = new Integer(192);
        Integer n3 = new Integer(128);
        Integer n4 = new Integer(256);
        algorithms.put("DES", n);
        algorithms.put("DESEDE", n2);
        algorithms.put("BLOWFISH", n3);
        algorithms.put("AES", n4);
    }
}

