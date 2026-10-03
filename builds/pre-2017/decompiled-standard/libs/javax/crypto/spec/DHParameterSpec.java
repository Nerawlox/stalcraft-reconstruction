/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class DHParameterSpec
implements AlgorithmParameterSpec {
    private BigInteger a;
    private BigInteger b;
    private int c;

    public DHParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = 0;
    }

    public DHParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, int n) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = n;
    }

    public BigInteger getP() {
        return this.a;
    }

    public BigInteger getG() {
        return this.b;
    }

    public int getL() {
        return this.c;
    }
}

