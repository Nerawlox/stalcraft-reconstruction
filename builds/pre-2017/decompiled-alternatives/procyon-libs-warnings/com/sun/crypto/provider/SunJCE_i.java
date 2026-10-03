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

class SunJCE_i extends SunJCE_e implements SunJCE_f
{
    private static final String a = "OFB";
    private byte[] b;
    private byte[] c;
    private SunJCE_e d;
    private byte[] e;
    private int f;
    private int g;
    
    public SunJCE_i() {
        this.b = null;
        this.e = null;
        this.f = -1;
        this.g = 8;
    }
    
    public SunJCE_i(final int g) {
        this.b = null;
        this.e = null;
        this.f = -1;
        this.g = 8;
        this.g = g;
    }
    
    public String b() {
        return "OFB";
    }
    
    void a(final SunJCE_e d) throws NoSuchAlgorithmException {
        if (d == null || (this.f = d.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.d = d;
        this.c = new byte[this.f];
        this.e = new byte[this.f];
        if (this.g > this.f) {
            this.g = this.f;
        }
    }
    
    public byte[] c() {
        return this.b;
    }
    
    public int a() {
        return this.f;
    }
    
    public int e() {
        return this.g * 8;
    }
    
    void a(final Key key) throws InvalidKeyException {
        this.d.a(key);
        final SecureRandom secureRandom = new SecureRandom();
        final byte[] array = new byte[this.f];
        secureRandom.nextBytes(array);
        System.arraycopy(array, 0, this.e, 0, this.f);
    }
    
    void a(final Key key, final AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.d.a(key);
        if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
        }
        this.b = ((IvParameterSpec)algorithmParameterSpec).getIV();
        if (this.b == null || this.b.length != 8) {
            throw new InvalidAlgorithmParameterException("Wrong IV length: must be 8 bytes long");
        }
        System.arraycopy(this.b, 0, this.e, 0, this.e.length);
    }
    
    public void d() {
        System.arraycopy(this.b, 0, this.e, 0, this.e.length);
    }
    
    void a(final byte[] array, int n, final int n2, final byte[] array2, int n3) throws IllegalBlockSizeException {
        final int n4 = this.f - this.g;
        int i = n2 / this.g;
        final int n5 = n2 % this.g;
        if (n4 == 0) {
            while (i > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int j = 0; j < this.g; ++j) {
                    array2[j + n3] = (byte)(this.c[j] ^ array[j + n]);
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
                n += this.g;
                n3 += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int k = 0; k < n5; ++k) {
                    array2[k + n3] = (byte)(this.c[k] ^ array[k + n]);
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
            }
        }
        else {
            while (i > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int l = 0; l < this.g; ++l) {
                    array2[l + n3] = (byte)(this.c[l] ^ array[l + n]);
                }
                System.arraycopy(this.e, this.g, this.e, 0, n4);
                System.arraycopy(this.c, 0, this.e, n4, this.g);
                n += this.g;
                n3 += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int n6 = 0; n6 < n5; ++n6) {
                    array2[n6 + n3] = (byte)(this.c[n6] ^ array[n6 + n]);
                }
                System.arraycopy(this.e, this.g, this.e, 0, n4);
                System.arraycopy(this.c, 0, this.e, n4, this.g);
            }
        }
    }
    
    void b(final byte[] array, int n, final int n2, final byte[] array2, int n3) throws IllegalBlockSizeException {
        final int n4 = this.f - this.g;
        int i = n2 / this.g;
        final int n5 = n2 % this.g;
        if (n4 == 0) {
            while (i > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int j = 0; j < this.g; ++j) {
                    array2[j + n3] = (byte)(array[j + n] ^ this.c[j]);
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
                n3 += this.g;
                n += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int k = 0; k < n5; ++k) {
                    array2[k + n3] = (byte)(array[k + n] ^ this.c[k]);
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
            }
        }
        else {
            while (i > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int l = 0; l < this.g; ++l) {
                    array2[l + n3] = (byte)(array[l + n] ^ this.c[l]);
                }
                System.arraycopy(this.e, this.g, this.e, 0, n4);
                System.arraycopy(this.c, 0, this.e, n4, this.g);
                n3 += this.g;
                n += this.g;
                --i;
            }
            if (n5 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                for (int n6 = 0; n6 < n5; ++n6) {
                    array2[n6 + n3] = (byte)(array[n6 + n] ^ this.c[n6]);
                }
                System.arraycopy(this.e, this.g, this.e, 0, n4);
                System.arraycopy(this.c, 0, this.e, n4, this.g);
            }
        }
    }
}
