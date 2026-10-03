/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class IESParameterSpec
implements AlgorithmParameterSpec {
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;

    public IESParameterSpec(byte[] byArray, byte[] byArray2, int n) {
        this.derivation = new byte[byArray.length];
        System.arraycopy(byArray, 0, this.derivation, 0, byArray.length);
        this.encoding = new byte[byArray2.length];
        System.arraycopy(byArray2, 0, this.encoding, 0, byArray2.length);
        this.macKeySize = n;
    }

    public byte[] getDerivationV() {
        return this.derivation;
    }

    public byte[] getEncodingV() {
        return this.encoding;
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }
}

