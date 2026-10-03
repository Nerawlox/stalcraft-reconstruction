/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RSACoreEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class RSABlindedEngine
implements AsymmetricBlockCipher {
    private static BigInteger ONE = BigInteger.valueOf(1L);
    private RSACoreEngine core = new RSACoreEngine();
    private RSAKeyParameters key;
    private SecureRandom random;

    public void init(boolean bl, CipherParameters cipherParameters) {
        this.core.init(bl, cipherParameters);
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom)cipherParameters;
            this.key = (RSAKeyParameters)parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            this.key = (RSAKeyParameters)cipherParameters;
            this.random = new SecureRandom();
        }
    }

    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    public byte[] processBlock(byte[] byArray, int n, int n2) {
        BigInteger bigInteger;
        if (this.key == null) {
            throw new IllegalStateException("RSA engine not initialised");
        }
        BigInteger bigInteger2 = this.core.convertInput(byArray, n, n2);
        if (this.key instanceof RSAPrivateCrtKeyParameters) {
            RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters)this.key;
            BigInteger bigInteger3 = rSAPrivateCrtKeyParameters.getPublicExponent();
            if (bigInteger3 != null) {
                BigInteger bigInteger4 = rSAPrivateCrtKeyParameters.getModulus();
                BigInteger bigInteger5 = BigIntegers.createRandomInRange(ONE, bigInteger4.subtract(ONE), this.random);
                BigInteger bigInteger6 = bigInteger5.modPow(bigInteger3, bigInteger4).multiply(bigInteger2).mod(bigInteger4);
                BigInteger bigInteger7 = this.core.processBlock(bigInteger6);
                BigInteger bigInteger8 = bigInteger5.modInverse(bigInteger4);
                bigInteger = bigInteger7.multiply(bigInteger8).mod(bigInteger4);
            } else {
                bigInteger = this.core.processBlock(bigInteger2);
            }
        } else {
            bigInteger = this.core.processBlock(bigInteger2);
        }
        return this.core.convertOutput(bigInteger);
    }
}

