/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class DHPrivateKeySpec
implements KeySpec {
    private BigInteger a;
    private BigInteger b;
    private BigInteger c;

    public DHPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
    }

    public BigInteger getX() {
        return this.a;
    }

    public BigInteger getP() {
        return this.b;
    }

    public BigInteger getG() {
        return this.c;
    }
}

