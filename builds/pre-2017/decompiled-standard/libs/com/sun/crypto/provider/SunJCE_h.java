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

class SunJCE_h
extends SunJCE_e
implements SunJCE_f {
    private static final String a = "CFB";
    private byte[] b;
    private byte[] c = null;
    private SunJCE_e d;
    private byte[] e = null;
    private int f = -1;
    private int g = 8;

    SunJCE_h() {
    }

    SunJCE_h(int n) {
        this.g = n;
    }

    public String b() {
        return a;
    }

    public byte[] c() {
        return this.e;
    }

    void a(SunJCE_e sunJCE_e) throws NoSuchAlgorithmException {
        if (sunJCE_e == null || (this.f = sunJCE_e.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.d = sunJCE_e;
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

    void a(Key key) throws InvalidKeyException {
        this.d.a(key);
        SecureRandom secureRandom = new SecureRandom();
        this.e = new byte[this.f];
        secureRandom.nextBytes(this.e);
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.d.a(key);
        if (algorithmParameterSpec != null && algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec)algorithmParameterSpec;
            this.e = ivParameterSpec.getIV();
            if (this.e == null || this.e.length != 8) {
                throw new InvalidAlgorithmParameterException("Wrong IV length: must be 8 bytes long");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
        }
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }

    public void d() {
        System.arraycopy(this.e, 0, this.c, 0, this.f);
    }

    /*
     * Unable to fully structure code
     */
    void a(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4, int var5_5) throws IllegalBlockSizeException {
        block7: {
            var7_6 = this.f - this.g;
            var8_7 = var2_2 + var3_3;
            var9_8 = var3_3 / this.g;
            var10_9 = var3_3 % this.g;
            if (var7_6 != 0) ** GOTO lbl41
            while (var9_8 > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                var6_10 = 0;
                while (var6_10 < this.f) {
                    v0 = (byte)(this.b[var6_10] ^ var1_1[var6_10 + var2_2]);
                    var4_4[var6_10 + var5_5] = v0;
                    this.c[var6_10] = v0;
                    ++var6_10;
                }
                var2_2 += this.g;
                var5_5 += this.g;
                --var9_8;
            }
            if (var10_9 <= 0) break block7;
            this.d.a(this.c, 0, this.f, this.b, 0);
            var6_10 = 0;
            while (var6_10 < var10_9) {
                v1 = (byte)(this.b[var6_10] ^ var1_1[var6_10 + var2_2]);
                var4_4[var6_10 + var5_5] = v1;
                this.c[var6_10] = v1;
                ++var6_10;
            }
            break block7;
lbl-1000:
            // 1 sources

            {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, var7_6);
                var6_11 = 0;
                while (var6_11 < this.g) {
                    v2 = (byte)(this.b[var6_11] ^ var1_1[var6_11 + var2_2]);
                    var4_4[var6_11 + var5_5] = v2;
                    this.c[var6_11 + var7_6] = v2;
                    ++var6_11;
                }
                var2_2 += this.g;
                var5_5 += this.g;
                --var9_8;
lbl41:
                // 2 sources

                ** while (var9_8 > 0)
            }
lbl42:
            // 1 sources

            if (var10_9 != 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, var7_6);
                var6_11 = 0;
                while (var6_11 < var10_9) {
                    v3 = (byte)(this.b[var6_11] ^ var1_1[var6_11 + var2_2]);
                    var4_4[var6_11 + var5_5] = v3;
                    this.c[var6_11 + var7_6] = v3;
                    ++var6_11;
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    void b(byte[] var1_1, int var2_2, int var3_3, byte[] var4_4, int var5_5) throws IllegalBlockSizeException {
        block7: {
            var7_6 = this.f - this.g;
            var8_7 = var2_2 + var3_3;
            var9_8 = var3_3 / this.g;
            var10_9 = var3_3 % this.g;
            if (var7_6 != 0) ** GOTO lbl38
            while (var9_8 > 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                var6_10 = 0;
                while (var6_10 < this.f) {
                    this.c[var6_10] = var1_1[var6_10 + var2_2];
                    var4_4[var6_10 + var5_5] = (byte)(var1_1[var6_10 + var2_2] ^ this.b[var6_10]);
                    ++var6_10;
                }
                var5_5 += this.g;
                var2_2 += this.g;
                --var9_8;
            }
            if (var10_9 <= 0) break block7;
            this.d.a(this.c, 0, this.f, this.b, 0);
            var6_10 = 0;
            while (var6_10 < var10_9) {
                this.c[var6_10] = var1_1[var6_10 + var2_2];
                var4_4[var6_10 + var5_5] = (byte)(var1_1[var6_10 + var2_2] ^ this.b[var6_10]);
                ++var6_10;
            }
            break block7;
lbl-1000:
            // 1 sources

            {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, var7_6);
                var6_11 = 0;
                while (var6_11 < this.g) {
                    this.c[var6_11 + var7_6] = var1_1[var6_11 + var2_2];
                    var4_4[var6_11 + var5_5] = (byte)(var1_1[var6_11 + var2_2] ^ this.b[var6_11]);
                    ++var6_11;
                }
                var5_5 += this.g;
                var2_2 += this.g;
                --var9_8;
lbl38:
                // 2 sources

                ** while (var9_8 > 0)
            }
lbl39:
            // 1 sources

            if (var10_9 != 0) {
                this.d.a(this.c, 0, this.f, this.b, 0);
                System.arraycopy(this.c, this.g, this.c, 0, var7_6);
                var6_11 = 0;
                while (var6_11 < var10_9) {
                    this.c[var6_11 + var7_6] = var1_1[var6_11 + var2_2];
                    var4_4[var6_11 + var5_5] = (byte)(var1_1[var6_11 + var2_2] ^ this.b[var6_11]);
                    ++var6_11;
                }
            }
        }
    }
}

