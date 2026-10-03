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

class SunJCE_j
extends SunJCE_e
implements SunJCE_f {
    private static final String a = "PCBC";
    private byte[] b = null;
    private byte[] c;
    private SunJCE_e d;
    private int e = -1;

    SunJCE_j() {
    }

    public String b() {
        return a;
    }

    void a(SunJCE_e sunJCE_e) throws NoSuchAlgorithmException {
        if (sunJCE_e == null || (this.e = sunJCE_e.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.d = sunJCE_e;
        this.c = new byte[this.e];
    }

    int a() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    void a(Key key) throws InvalidKeyException {
        this.d.a(key);
        SecureRandom secureRandom = new SecureRandom();
        this.b = new byte[this.e];
        secureRandom.nextBytes(this.b);
        System.arraycopy(this.b, 0, this.c, 0, this.e);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.d.a(key);
        if (algorithmParameterSpec != null && algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec)algorithmParameterSpec;
            this.b = ivParameterSpec.getIV();
            if (this.b == null || this.b.length != 8) {
                throw new InvalidAlgorithmParameterException("Wrong IV length: must be 8 bytes long");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
        }
        System.arraycopy(this.b, 0, this.c, 0, this.e);
    }

    public void d() {
        System.arraycopy(this.b, 0, this.c, 0, this.e);
    }

    void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        int n4 = n + n2;
        while (n < n4) {
            int n5 = 0;
            while (n5 < this.e) {
                int n6 = n5;
                this.c[n6] = (byte)(this.c[n6] ^ byArray[n5 + n]);
                ++n5;
            }
            this.d.a(this.c, 0, this.e, byArray2, n3);
            n5 = 0;
            while (n5 < this.e) {
                this.c[n5] = (byte)(byArray[n5 + n] ^ byArray2[n5 + n3]);
                ++n5;
            }
            n += this.e;
            n3 += this.e;
        }
    }

    void b(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        int n4 = n + n2;
        while (n < n4) {
            this.d.b(byArray, n, this.e, byArray2, n3);
            int n5 = 0;
            while (n5 < this.e) {
                int n6 = n5 + n3;
                byArray2[n6] = (byte)(byArray2[n6] ^ this.c[n5]);
                ++n5;
            }
            n5 = 0;
            while (n5 < this.e) {
                this.c[n5] = (byte)(byArray2[n5 + n3] ^ byArray[n5 + n]);
                ++n5;
            }
            n3 += this.e;
            n += this.e;
        }
    }
}

