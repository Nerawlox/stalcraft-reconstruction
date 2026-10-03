/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

public class PBEParameterSpec
implements AlgorithmParameterSpec {
    private byte[] a;
    private int b;

    public PBEParameterSpec(byte[] byArray, int n) {
        this.a = (byte[])byArray.clone();
        this.b = n;
    }

    public byte[] getSalt() {
        return (byte[])this.a.clone();
    }

    public int getIterationCount() {
        return this.b;
    }
}

