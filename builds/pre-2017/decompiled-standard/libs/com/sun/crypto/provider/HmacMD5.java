/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;

public final class HmacMD5
extends MacSpi
implements Cloneable {
    private MessageDigest a;
    private byte[] b;
    private byte[] c;
    private boolean d = true;
    private static final int e = 16;
    private static final int f = 64;

    public HmacMD5() throws NoSuchAlgorithmException {
        SunJCE.a();
        if (!SunJCE.a(this.getClass())) {
            throw new SecurityException("The SunJCE provider may have been tampered.");
        }
        this.a = MessageDigest.getInstance("MD5");
        this.b = new byte[64];
        this.c = new byte[64];
    }

    protected int engineGetMacLength() {
        return this.a.getDigestLength();
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        int n;
        if (key == null || !(key instanceof SecretKey)) {
            throw new InvalidKeyException("Secret key expected");
        }
        byte[] byArray = key.getEncoded();
        if (byArray == null || byArray.length == 0) {
            throw new InvalidKeyException("Missing key data");
        }
        if (byArray.length > 64) {
            byArray = this.a.digest(byArray);
        }
        byte[] byArray2 = null;
        if (byArray.length == 64) {
            byArray2 = byArray;
        } else {
            byArray2 = new byte[64];
            System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
            n = byArray.length;
            while (n < 64) {
                byArray2[n] = 0;
                ++n;
            }
        }
        n = 0;
        while (n < 64) {
            this.b[n] = (byte)(byArray2[n] ^ 0x36);
            this.c[n] = (byte)(byArray2[n] ^ 0x5C);
            ++n;
        }
        n = 0;
        while (n < byArray.length) {
            byArray[n] = 0;
            ++n;
        }
        if (byArray2 != byArray) {
            n = 0;
            while (n < byArray2.length) {
                byArray2[n] = 0;
                ++n;
            }
        }
        byArray = null;
        byArray2 = null;
    }

    protected void engineUpdate(byte by) {
        if (this.d) {
            this.a.update(this.b);
            this.d = false;
        }
        this.a.update(by);
    }

    protected void engineUpdate(byte[] byArray, int n, int n2) {
        if (this.d) {
            this.a.update(this.b);
            this.d = false;
        }
        this.a.update(byArray, n, n2);
    }

    protected byte[] engineDoFinal() {
        if (this.d) {
            this.a.update(this.b);
        } else {
            this.d = true;
        }
        byte[] byArray = this.a.digest();
        this.a.update(this.c);
        return this.a.digest(byArray);
    }

    protected void engineReset() {
        this.a.reset();
        this.d = true;
    }

    public Object clone() {
        HmacMD5 hmacMD5 = null;
        try {
            hmacMD5 = (HmacMD5)super.clone();
            hmacMD5.a = (MessageDigest)this.a.clone();
            hmacMD5.b = (byte[])this.b.clone();
            hmacMD5.c = (byte[])this.c.clone();
            hmacMD5.d = this.d;
            return hmacMD5;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return hmacMD5;
        }
    }
}

