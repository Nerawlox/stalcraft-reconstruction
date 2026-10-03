/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class RC2Parameters
implements CipherParameters {
    private byte[] key;
    private int bits;

    public RC2Parameters(byte[] byArray) {
        this(byArray, byArray.length > 128 ? 1024 : byArray.length * 8);
    }

    public RC2Parameters(byte[] byArray, int n) {
        this.key = new byte[byArray.length];
        this.bits = n;
        System.arraycopy(byArray, 0, this.key, 0, byArray.length);
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getEffectiveKeyBits() {
        return this.bits;
    }
}

