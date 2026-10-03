/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESedeCipher;
import com.sun.crypto.provider.DESedeKey;
import com.sun.crypto.provider.SunJCE;
import com.sun.crypto.provider.SunJCE_k;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;

public final class PBEWithMD5AndTripleDESCipher
extends CipherSpi {
    protected DESedeCipher a;
    protected byte[] b;
    protected int c = 10;
    static /* synthetic */ Class d;

    public PBEWithMD5AndTripleDESCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
        this.a = new DESedeCipher();
        this.a.engineSetMode("CBC");
        this.a.engineSetPadding("PKCS5Padding");
    }

    protected void engineSetMode(String string) throws NoSuchAlgorithmException {
        if (string != null && !string.equalsIgnoreCase("CBC")) {
            throw new NoSuchAlgorithmException("Invalid cipher mode: " + string);
        }
    }

    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        if (string != null && !string.equalsIgnoreCase("PKCS5Padding")) {
            throw new NoSuchPaddingException("Invalid padding scheme: " + string);
        }
    }

    protected int engineGetBlockSize() {
        return this.a.engineGetBlockSize();
    }

    protected int engineGetOutputSize(int n) {
        return this.a.engineGetOutputSize(n);
    }

    protected byte[] engineGetIV() {
        return this.a.engineGetIV();
    }

    protected AlgorithmParameters engineGetParameters() {
        AlgorithmParameters algorithmParameters = null;
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(this.b, this.c);
        try {
            algorithmParameters = AlgorithmParameters.getInstance("PBE", "SunJCE");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SunJCE called, but not configured");
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new RuntimeException("SunJCE called, but not configured");
        }
        try {
            algorithmParameters.init(pBEParameterSpec);
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new RuntimeException("PBEParameterSpec not supported");
        }
        return algorithmParameters;
    }

    protected void engineInit(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (n == 2 || n == 4) {
            throw new InvalidKeyException("Parameters missing");
        }
        try {
            this.engineInit(n, key, (AlgorithmParameterSpec)null, secureRandom);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new RuntimeException(invalidAlgorithmParameterException.getMessage());
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (n == 2 && algorithmParameterSpec == null) {
            throw new InvalidAlgorithmParameterException("Parameters missing");
        }
        try {
            if (key == null || !key.getAlgorithm().equalsIgnoreCase("PBEWithMD5AndDES")) {
                throw new InvalidKeyException("Missing password");
            }
            byte[] byArray = key.getEncoded();
            if (algorithmParameterSpec == null) {
                this.b = new byte[8];
                secureRandom.nextBytes(this.b);
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong parameter type");
                }
                this.b = ((PBEParameterSpec)algorithmParameterSpec).getSalt();
                if (this.b.length != 8) {
                    throw new InvalidAlgorithmParameterException("Salt must be 8 bytes long");
                }
                this.c = ((PBEParameterSpec)algorithmParameterSpec).getIterationCount();
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int n2 = 0;
            while (n2 < 4) {
                if (this.b[n2] != this.b[n2 + 4]) break;
                ++n2;
            }
            if (n2 == 4) {
                n2 = 0;
                while (n2 < 2) {
                    byte by = this.b[n2];
                    this.b[n2] = this.b[3 - n2];
                    this.b[2] = by;
                    ++n2;
                }
            }
            byte[] byArray2 = null;
            IvParameterSpec ivParameterSpec = null;
            byte[] byArray3 = null;
            n2 = 0;
            while (n2 < 2) {
                byArray3 = new byte[this.b.length / 2];
                System.arraycopy(this.b, n2 * (this.b.length / 2), byArray3, 0, byArray3.length);
                int n3 = 0;
                while (n3 < this.c) {
                    messageDigest.update(byArray3);
                    messageDigest.update(byArray);
                    byArray3 = messageDigest.digest();
                    ++n3;
                }
                if (n2 == 0) {
                    byArray2 = new byte[24];
                    System.arraycopy(byArray3, 0, byArray2, 0, byArray3.length);
                } else {
                    System.arraycopy(byArray3, 0, byArray2, byArray3.length, byArray3.length / 2);
                    ivParameterSpec = new IvParameterSpec(byArray3, byArray3.length / 2, byArray3.length / 2);
                }
                ++n2;
            }
            Arrays.fill(byArray, (byte)0);
            DESedeKey dESedeKey = new DESedeKey(byArray2);
            this.a.engineInit(n, (Key)dESedeKey, ivParameterSpec, secureRandom);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InvalidKeyException(noSuchAlgorithmException.toString());
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        PBEParameterSpec pBEParameterSpec = null;
        if (algorithmParameters != null) {
            try {
                pBEParameterSpec = (PBEParameterSpec)algorithmParameters.getParameterSpec(d == null ? (d = PBEWithMD5AndTripleDESCipher.class$("javax.crypto.spec.PBEParameterSpec")) : d);
            }
            catch (InvalidParameterSpecException invalidParameterSpecException) {
                throw new InvalidAlgorithmParameterException("Wrong parameter type: PBE expected");
            }
        }
        this.engineInit(n, key, pBEParameterSpec, secureRandom);
    }

    protected byte[] engineUpdate(byte[] byArray, int n, int n2) {
        return this.a.engineUpdate(byArray, n, n2);
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws ShortBufferException {
        return this.a.engineUpdate(byArray, n, n2, byArray2, n3);
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) throws IllegalBlockSizeException, BadPaddingException {
        return this.a.engineDoFinal(byArray, n, n2);
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return this.a.engineDoFinal(byArray, n, n2, byArray2, n3);
    }

    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        return 168;
    }

    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] byArray = null;
        try {
            byte[] byArray2 = key.getEncoded();
            if (byArray2 == null || byArray2.length == 0) {
                throw new InvalidKeyException("Cannot get an encoding of the key to be wrapped");
            }
            byArray = this.engineDoFinal(byArray2, 0, byArray2.length);
        }
        catch (BadPaddingException badPaddingException) {
            // empty catch block
        }
        return byArray;
    }

    protected Key engineUnwrap(byte[] byArray, String string, int n) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] byArray2;
        Key key = null;
        try {
            byArray2 = this.engineDoFinal(byArray, 0, byArray.length);
        }
        catch (BadPaddingException badPaddingException) {
            throw new InvalidKeyException();
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new InvalidKeyException();
        }
        switch (n) {
            case 3: {
                key = SunJCE_k.c(byArray2, string);
                break;
            }
            case 2: {
                key = SunJCE_k.b(byArray2, string);
                break;
            }
            case 1: {
                key = SunJCE_k.a(byArray2, string);
            }
        }
        return key;
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

