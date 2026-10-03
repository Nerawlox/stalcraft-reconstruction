/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_e;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;

class SunJCE_ab
extends SunJCE_e {
    private SunJCE_e a = null;
    private int b = -1;

    SunJCE_ab() {
    }

    void a(SunJCE_e sunJCE_e) throws NoSuchAlgorithmException {
        if (sunJCE_e == null || (this.b = sunJCE_e.a()) <= 0) {
            throw new NoSuchAlgorithmException("Incompatible algorithm type and mode");
        }
        this.a = sunJCE_e;
    }

    int a() {
        if (this.a == null) {
            return -1;
        }
        return this.a.a();
    }

    void a(Key key) throws InvalidKeyException {
        this.a.a(key);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.a(key);
    }

    void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        int n4 = n + n2;
        while (n < n4) {
            this.a.a(byArray, n, this.b, byArray2, n3);
            n += this.b;
            n3 += this.b;
        }
    }

    void b(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        int n4 = n + n2;
        while (n < n4) {
            this.a.b(byArray, n, this.b, byArray2, n3);
            n3 += this.b;
            n += this.b;
        }
    }
}

