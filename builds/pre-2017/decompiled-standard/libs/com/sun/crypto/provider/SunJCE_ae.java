/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_ad;
import com.sun.crypto.provider.SunJCE_s;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;

class SunJCE_ae
extends SunJCE_ad
implements SunJCE_s {
    private byte[] a;
    private byte[] b;
    private byte[] c;
    private byte[] d = new byte[8];
    private byte[] e = new byte[8];

    SunJCE_ae() {
    }

    void a(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("Key missing");
        }
        if (!key.getAlgorithm().equalsIgnoreCase("DESede") && !key.getAlgorithm().equalsIgnoreCase("TripleDES")) {
            throw new InvalidKeyException("Wrong algorithm: DESede or TripleDES required");
        }
        if (!key.getFormat().equalsIgnoreCase("RAW")) {
            throw new InvalidKeyException("Wrong format: RAW bytes needed");
        }
        byte[] byArray = key.getEncoded();
        if (byArray == null) {
            throw new InvalidKeyException("RAW bytes missing");
        }
        if (byArray.length != 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        byte[] byArray2 = new byte[8];
        this.a = new byte[128];
        System.arraycopy(byArray, 0, byArray2, 0, 8);
        this.a(byArray2);
        System.arraycopy(((SunJCE_ad)this).a, 0, this.a, 0, 128);
        if (this.a(byArray2, 0, byArray, 16, 8)) {
            this.c = this.a;
        } else {
            this.c = new byte[128];
            System.arraycopy(byArray, 16, byArray2, 0, 8);
            this.a(byArray2);
            System.arraycopy(((SunJCE_ad)this).a, 0, this.c, 0, 128);
        }
        this.b = new byte[128];
        System.arraycopy(byArray, 8, byArray2, 0, 8);
        this.a(byArray2);
        System.arraycopy(((SunJCE_ad)this).a, 0, this.b, 0, 128);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        this.a(key);
    }

    void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalStateException, IllegalBlockSizeException {
        if (this.a == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (n2 != 8) {
            throw new IllegalBlockSizeException("SunJCE DESede : " + n2);
        }
        ((SunJCE_ad)this).a = this.a;
        ((SunJCE_ad)this).b = false;
        this.a(byArray, n, this.d, 0);
        ((SunJCE_ad)this).a = this.b;
        ((SunJCE_ad)this).b = true;
        this.a(this.d, 0, this.e, 0);
        ((SunJCE_ad)this).a = this.c;
        ((SunJCE_ad)this).b = false;
        this.a(this.e, 0, byArray2, n3);
    }

    void b(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalStateException, IllegalBlockSizeException {
        if (this.a == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (n2 != 8) {
            throw new IllegalBlockSizeException("SunJCE DESede: " + n2);
        }
        ((SunJCE_ad)this).a = this.c;
        ((SunJCE_ad)this).b = true;
        this.a(byArray, n, this.d, 0);
        ((SunJCE_ad)this).a = this.b;
        ((SunJCE_ad)this).b = false;
        this.a(this.d, 0, this.e, 0);
        ((SunJCE_ad)this).a = this.a;
        ((SunJCE_ad)this).b = true;
        this.a(this.e, 0, byArray2, n3);
    }

    private boolean a(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        int n4 = 0;
        while (n4 < n3) {
            if (byArray[n4 + n] != byArray2[n4 + n2]) {
                return false;
            }
            ++n4;
        }
        return true;
    }
}

