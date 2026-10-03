/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RSAKeyParameters
extends AsymmetricKeyParameter {
    private BigInteger modulus;
    private BigInteger exponent;

    public RSAKeyParameters(boolean bl, BigInteger bigInteger, BigInteger bigInteger2) {
        super(bl);
        this.modulus = bigInteger;
        this.exponent = bigInteger2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getExponent() {
        return this.exponent;
    }
}

