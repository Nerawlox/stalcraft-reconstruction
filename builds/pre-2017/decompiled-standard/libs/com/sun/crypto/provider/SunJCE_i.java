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

class SunJCE_i
extends SunJCE_e
implements SunJCE_f {
    private static final String a = "OFB";
    private byte[] b = null;
    private byte[] c;
    private SunJCE_e d;
    private byte[] e = null;
    private int f = -1;
    private int g = 8;

    public SunJCE_i() {
    }

    public SunJCE_i(int n) {
        this.g = n;
    }

    public String b() {
        return a;
    }

    void a(SunJCE_e sunJCE_e) throws NoSuchAlgorithmException {
        if (sunJCE_e == null || (this.f = sunJCE_e.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.d = sunJCE_e;
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

    void a(Key key) throws InvalidKeyException {
        this.d.a(key);
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[this.f];
        secureRandom.nextBytes(byArray);
        System.arraycopy(byArray, 0, this.e, 0, this.f);
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
        System.arraycopy(this.b, 0, this.e, 0, this.e.length);
    }

    public void d() {
        System.arraycopy(this.b, 0, this.e, 0, this.e.length);
    }

    /*
     * Unable to fully structure code
     */
    void a(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4, int var5_5) throws IllegalBlockSizeException {
        block10: {
            var7_6 = this.f - this.g;
            var8_7 = var2_2 + var3_3;
            var9_8 = var3_3 / this.g;
            var10_9 = var3_3 % this.g;
            if (var7_6 != 0) ** GOTO lbl38
            while (var9_8 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_10 = 0;
                while (var6_10 < this.g) {
                    var4_4[var6_10 + var5_5] = (byte)(this.c[var6_10] ^ var1_1[var6_10 + var2_2]);
                    ++var6_10;
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
                var2_2 += this.g;
                var5_5 += this.g;
                --var9_8;
            }
            if (var10_9 <= 0) break block10;
            this.d.a(this.e, 0, this.f, this.c, 0);
            var6_10 = 0;
            while (var6_10 < var10_9) {
                var4_4[var6_10 + var5_5] = (byte)(this.c[var6_10] ^ var1_1[var6_10 + var2_2]);
                ++var6_10;
            }
            System.arraycopy(this.c, 0, this.e, 0, this.g);
            break block10;
lbl-1000:
            // 1 sources

            {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_11 = 0;
                while (var6_11 < this.g) {
                    var4_4[var6_11 + var5_5] = (byte)(this.c[var6_11] ^ var1_1[var6_11 + var2_2]);
                    ++var6_11;
                }
                System.arraycopy(this.e, this.g, this.e, 0, var7_6);
                System.arraycopy(this.c, 0, this.e, var7_6, this.g);
                var2_2 += this.g;
                var5_5 += this.g;
                --var9_8;
lbl38:
                // 2 sources

                ** while (var9_8 > 0)
            }
lbl39:
            // 1 sources

            if (var10_9 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_11 = 0;
                while (var6_11 < var10_9) {
                    var4_4[var6_11 + var5_5] = (byte)(this.c[var6_11] ^ var1_1[var6_11 + var2_2]);
                    ++var6_11;
                }
                System.arraycopy(this.e, this.g, this.e, 0, var7_6);
                System.arraycopy(this.c, 0, this.e, var7_6, this.g);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    void b(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4, int var5_5) throws IllegalBlockSizeException {
        block10: {
            var7_6 = this.f - this.g;
            var8_7 = var2_2 + var3_3;
            var9_8 = var3_3 / this.g;
            var10_9 = var3_3 % this.g;
            if (var7_6 != 0) ** GOTO lbl38
            while (var9_8 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_10 = 0;
                while (var6_10 < this.g) {
                    var4_4[var6_10 + var5_5] = (byte)(var1_1[var6_10 + var2_2] ^ this.c[var6_10]);
                    ++var6_10;
                }
                System.arraycopy(this.c, 0, this.e, 0, this.g);
                var5_5 += this.g;
                var2_2 += this.g;
                --var9_8;
            }
            if (var10_9 <= 0) break block10;
            this.d.a(this.e, 0, this.f, this.c, 0);
            var6_10 = 0;
            while (var6_10 < var10_9) {
                var4_4[var6_10 + var5_5] = (byte)(var1_1[var6_10 + var2_2] ^ this.c[var6_10]);
                ++var6_10;
            }
            System.arraycopy(this.c, 0, this.e, 0, this.g);
            break block10;
lbl-1000:
            // 1 sources

            {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_11 = 0;
                while (var6_11 < this.g) {
                    var4_4[var6_11 + var5_5] = (byte)(var1_1[var6_11 + var2_2] ^ this.c[var6_11]);
                    ++var6_11;
                }
                System.arraycopy(this.e, this.g, this.e, 0, var7_6);
                System.arraycopy(this.c, 0, this.e, var7_6, this.g);
                var5_5 += this.g;
                var2_2 += this.g;
                --var9_8;
lbl38:
                // 2 sources

                ** while (var9_8 > 0)
            }
lbl39:
            // 1 sources

            if (var10_9 > 0) {
                this.d.a(this.e, 0, this.f, this.c, 0);
                var6_11 = 0;
                while (var6_11 < var10_9) {
                    var4_4[var6_11 + var5_5] = (byte)(var1_1[var6_11 + var2_2] ^ this.c[var6_11]);
                    ++var6_11;
                }
                System.arraycopy(this.e, this.g, this.e, 0, var7_6);
                System.arraycopy(this.c, 0, this.e, var7_6, this.g);
            }
        }
    }
}

