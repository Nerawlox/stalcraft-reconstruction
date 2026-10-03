/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;

public class SRP6Client {
    protected BigInteger N;
    protected BigInteger g;
    protected BigInteger a;
    protected BigInteger A;
    protected BigInteger B;
    protected BigInteger x;
    protected BigInteger u;
    protected BigInteger S;
    protected Digest digest;
    protected SecureRandom random;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest, SecureRandom secureRandom) {
        this.N = bigInteger;
        this.g = bigInteger2;
        this.digest = digest;
        this.random = secureRandom;
    }

    public BigInteger generateClientCredentials(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        this.x = SRP6Util.calculateX(this.digest, this.N, byArray, byArray2, byArray3);
        this.a = this.selectPrivateValue();
        this.A = this.g.modPow(this.a, this.N);
        return this.A;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        this.B = SRP6Util.validatePublicValue(this.N, bigInteger);
        this.u = SRP6Util.calculateU(this.digest, this.N, this.A, this.B);
        this.S = this.calculateS();
        return this.S;
    }

    protected BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.g, this.random);
    }

    private BigInteger calculateS() {
        BigInteger bigInteger = SRP6Util.calculateK(this.digest, this.N, this.g);
        BigInteger bigInteger2 = this.u.multiply(this.x).add(this.a);
        BigInteger bigInteger3 = this.g.modPow(this.x, this.N).multiply(bigInteger).mod(this.N);
        return this.B.subtract(bigInteger3).mod(this.N).modPow(bigInteger2, this.N);
    }
}

