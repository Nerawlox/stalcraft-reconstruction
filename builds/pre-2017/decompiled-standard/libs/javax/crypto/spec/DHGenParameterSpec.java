/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

public class DHGenParameterSpec
implements AlgorithmParameterSpec {
    private int a;
    private int b;

    public DHGenParameterSpec(int n, int n2) {
        this.a = n;
        this.b = n2;
    }

    public int getPrimeSize() {
        return this.a;
    }

    public int getExponentSize() {
        return this.b;
    }
}

