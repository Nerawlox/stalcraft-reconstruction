// 
// Decompiled by Procyon v0.6.0
// 

package com.sun.crypto.provider;

import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

class SunJCE_h extends SunJCE_e implements SunJCE_f
{
    private static final String a = "CFB";
    private byte[] b;
    private byte[] c;
    private SunJCE_e d;
    private byte[] e;
    private int f;
    private int g;
    
    SunJCE_h() {
        this.c = null;
        this.e = null;
        this.f = -1;
        this.g = 8;
    }
    
    SunJCE_h(final int g) {
        this.c = null;
        this.e = null;
        this.f = -1;
        this.g = 8;
        this.g = g;
    }
    
    public String b() {
        return "CFB";
    }
    
    public byte[] c() {
        return this.e;
    }
    
    void a(final SunJCE_e d) throws NoSuchAlgorithmException {
        if (d == null || (this.f = d.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.d = d;
        this.b = new byte[this.f];
        this.c = new byte[this.f];
        if (this.g > this.f) {
            this.g = this.f;
        }
    }
    
    int a() {
        return this.f;
    }
    
    int e() {
        return this.g * 8;
    }
    
    void a(final Key key) throws InvalidKeyException {
        this.d.a(key);
        new SecureRandom().nextBytes(this.e = new byte[this.f]);
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }
    
    void a(final Key key, final AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.d.a(key);
        if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
        }
        this.e = ((IvParameterSpec)algorithmParameterSpec).getIV();
        if (this.e == null || this.e.length != 8) {
            throw new InvalidAlgorithmParameterException("Wrong IV length: must be 8 bytes long");
        }
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }
    
    public void d() {
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }
    
    void a(final byte[] array, int n, final int n2, final byte[] array2, int n3) throws IllegalBlockSizeException {
        final int n4 = this.f - this.g;
        int i = n2 / this.g;
        final int n5 = n2 % this.g;
        if (n4 == 0) {
            while (i > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                for (int j = 0; j < this.f; ++j) {
                    this.c[j] = (array2[j + n3] = (byte)(this.b[j] ^ array[j + n]));
                }
                n += this.g;
                n3 += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                for (int k = 0; k < n5; ++k) {
                    this.c[k] = (array2[k + n3] = (byte)(this.b[k] ^ array[k + n]));
                }
            }
        }
        else {
            while (i > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, n4);
                for (int l = 0; l < this.g; ++l) {
                    this.c[l + n4] = (array2[l + n3] = (byte)(this.b[l] ^ array[l + n]));
                }
                n += this.g;
                n3 += this.g;
                --i;
            }
            if (n5 != 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, n4);
                for (int n6 = 0; n6 < n5; ++n6) {
                    this.c[n6 + n4] = (array2[n6 + n3] = (byte)(this.b[n6] ^ array[n6 + n]));
                }
            }
        }
    }
    
    void b(final byte[] array, int n, final int n2, final byte[] array2, int n3) throws IllegalBlockSizeException {
        final int n4 = this.f - this.g;
        int i = n2 / this.g;
        final int n5 = n2 % this.g;
        if (n4 == 0) {
            while (i > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                for (int j = 0; j < this.f; ++j) {
                    this.c[j] = array[j + n];
                    array2[j + n3] = (byte)(array[j + n] ^ this.b[j]);
                }
                n3 += this.g;
                n += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                for (int k = 0; k < n5; ++k) {
                    this.c[k] = array[k + n];
                    array2[k + n3] = (byte)(array[k + n] ^ this.b[k]);
                }
            }
        }
        else {
            while (i > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, n4);
                for (int l = 0; l < this.g; ++l) {
                    this.c[l + n4] = array[l + n];
                    array2[l + n3] = (byte)(array[l + n] ^ this.b[l]);
                }
                n3 += this.g;
                n += this.g;
                --i;
            }
            if (n5 != 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, n4);
                for (int n6 = 0; n6 < n5; ++n6) {
                    this.c[n6 + n4] = array[n6 + n];
                    array2[n6 + n3] = (byte)(array[n6 + n] ^ this.b[n6]);
                }
            }
        }
    }
}
