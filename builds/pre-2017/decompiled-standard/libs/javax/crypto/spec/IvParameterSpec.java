/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

public class IvParameterSpec
implements AlgorithmParameterSpec {
    private byte[] a;

    public IvParameterSpec(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public IvParameterSpec(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new IllegalArgumentException("IV missing");
        }
        if (byArray.length - n < n2) {
            throw new IllegalArgumentException("IV buffer too short for given offset/length combination");
        }
        this.a = new byte[n2];
        System.arraycopy(byArray, n, this.a, 0, n2);
    }

    public byte[] getIV() {
        return (byte[])this.a.clone();
    }
}

