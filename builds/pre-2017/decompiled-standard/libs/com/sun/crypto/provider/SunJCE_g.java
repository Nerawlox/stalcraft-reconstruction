/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_e;
import com.sun.crypto.provider.SunJCE_f;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;

class SunJCE_g
extends SunJCE_e
implements SunJCE_f {
    private static final String a = "CBC";
    private byte[] b = null;
    private byte[] c;
    private byte[] d;
    private SunJCE_e e;
    private int f = -1;

    SunJCE_g() {
    }

    public String b() {
        return a;
    }

    void a(SunJCE_e sunJCE_e) throws NoSuchAlgorithmException {
        if (sunJCE_e == null || (this.f = sunJCE_e.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.e = sunJCE_e;
        this.d = new byte[this.f];
        this.c = new byte[this.f];
    }

    int a() {
        return this.f;
    }

    public byte[] c() {
        return this.b;
    }

    void a(Key key) throws InvalidKeyException {
        this.e.a(key);
        SecureRandom secureRandom = new SecureRandom();
        this.b = new byte[this.f];
        secureRandom.nextBytes(this.b);
        System.arraycopy(this.b, 0, this.c, 0, this.f);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.e.a(key);
        if (algorithmParameterSpec != null && algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec)algorithmParameterSpec;
            this.b = ivParameterSpec.getIV();
            if (this.b == null || this.b.length != 8) {
                throw new InvalidAlgorithmParameterException("Wrong IV length: must be 8 bytes long");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
        }
        System.arraycopy(this.b, 0, this.c, 0, this.f);
    }

    public void d() {
        System.arraycopy(this.b, 0, this.c, 0, this.f);
    }

    void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        int n4 = n + n2;
        while (n < n4) {
            int n5 = 0;
            while (n5 < this.f) {
                this.d[n5] = (byte)(byArray[n5 + n] ^ this.c[n5]);
                ++n5;
            }
            this.e.a(this.d, 0, this.f, byArray2, n3);
            System.arraycopy(byArray2, n3, this.c, 0, this.f);
            n += this.f;
            n3 += this.f;
        }
    }

    void b(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        byte[] byArray3 = null;
        int n4 = n + n2;
        if (byArray == byArray2 && n >= n3 && n - n3 < this.f) {
            byArray3 = (byte[])byArray.clone();
        }
        while (n < n4) {
            this.e.b(byArray, n, this.f, this.d, 0);
            int n5 = 0;
            while (n5 < this.f) {
                byArray2[n5 + n3] = (byte)(this.d[n5] ^ this.c[n5]);
                ++n5;
            }
            if (byArray3 == null) {
                System.arraycopy(byArray, n, this.c, 0, this.f);
            } else {
                System.arraycopy(byArray3, n, this.c, 0, this.f);
            }
            n += this.f;
            n3 += this.f;
        }
    }
}

