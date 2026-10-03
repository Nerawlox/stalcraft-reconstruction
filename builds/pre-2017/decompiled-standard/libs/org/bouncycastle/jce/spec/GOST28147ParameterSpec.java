/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.engines.GOST28147Engine;

public class GOST28147ParameterSpec
implements AlgorithmParameterSpec {
    private byte[] iv = null;
    private byte[] sBox = null;

    public GOST28147ParameterSpec(byte[] byArray) {
        this.sBox = new byte[byArray.length];
        System.arraycopy(byArray, 0, this.sBox, 0, byArray.length);
    }

    public GOST28147ParameterSpec(byte[] byArray, byte[] byArray2) {
        this(byArray);
        this.iv = new byte[byArray2.length];
        System.arraycopy(byArray2, 0, this.iv, 0, byArray2.length);
    }

    public GOST28147ParameterSpec(String string) {
        this.sBox = GOST28147Engine.getSBox(string);
    }

    public GOST28147ParameterSpec(String string, byte[] byArray) {
        this(string);
        this.iv = new byte[byArray.length];
        System.arraycopy(byArray, 0, this.iv, 0, byArray.length);
    }

    public byte[] getSbox() {
        return this.sBox;
    }

    public byte[] getIV() {
        if (this.iv == null) {
            return null;
        }
        byte[] byArray = new byte[this.iv.length];
        System.arraycopy(this.iv, 0, byArray, 0, byArray.length);
        return byArray;
    }
}

